package com.ktg.ktg_springboot_backend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour gérer les opérations CRUD sur les personnes.
 * Toutes les routes commencent par "/api/persons".
 */
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    /**
     * Injection du service PersonService via le constructeur.
     * Cela favorise l'injection de dépendances et améliore la testabilité du code.
     *
     * @param personService Service pour gérer la logique métier des personnes.
     */
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Récupérer la liste de toutes les personnes.
     *
     * @return ResponseEntity contenant la liste des personnes et un code HTTP 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    /**
     * Récupérer une personne par son ID.
     *
     * @param id Identifiant unique de la personne.
     * @return ResponseEntity contenant la personne trouvée ou un code HTTP 404 (NOT FOUND) si elle n'existe pas.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return personService.findById(id)
                .map(person -> new ResponseEntity<>(person, HttpStatus.OK)) // Si trouvé, retourner 200 OK
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Sinon, retourner 404
    }

    /**
     * Ajouter une nouvelle personne dans la base de données.
     *
     * @param person Objet Person reçu dans le corps de la requête.
     * @return ResponseEntity contenant la personne créée et un code HTTP 201 (CREATED).
     */
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person personCreated = personService.save(person);
        return new ResponseEntity<>(personCreated, HttpStatus.CREATED);
    }

    /**
     * Mettre à jour les informations d'une personne existante.
     *
     * @param id            Identifiant de la personne à mettre à jour.
     * @param personDetails Nouvelles informations de la personne.
     * @return ResponseEntity contenant la personne mise à jour et un code HTTP 200 (OK).
     */
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person personDetails) {
        Person updatedPerson = personService.update(id, personDetails);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }

    /**
     * Supprimer une personne par son ID.
     *
     * @param id Identifiant unique de la personne à supprimer.
     * @return ResponseEntity avec un code HTTP 204 (NO CONTENT) si la suppression est réussie.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
