package com.ktg.ktg_springboot_backend;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation de l'interface PersonService.
 * Gère la logique métier pour l'entité Person.
 */
@Service // Indique à Spring que cette classe est un service et doit être gérée comme un bean Spring
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    /**
     * Constructeur avec injection de dépendance.
     * Spring injecte automatiquement un bean PersonRepository.
     *
     * @param personRepository Le repository utilisé pour interagir avec la base de données.
     */
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Récupère la liste complète des personnes enregistrées.
     *
     * @return Liste de toutes les personnes présentes en base.
     */
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    /**
     * Recherche une personne par son identifiant.
     *
     * @param id Identifiant unique de la personne.
     * @return Un objet Optional contenant la personne si trouvée, sinon un Optional vide.
     */
    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    /**
     * Enregistre une nouvelle personne dans la base de données.
     *
     * @param person Objet Person à enregistrer.
     * @return La personne sauvegardée avec son identifiant généré.
     */
    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    /**
     * Met à jour les informations d'une personne existante.
     *
     * @param id Identifiant de la personne à mettre à jour.
     * @param personDetails Nouvelles informations de la personne.
     * @return L'objet Person mis à jour.
     * @throws ResourceNotFoundException si l'identifiant n'existe pas.
     */
    @Override
    public Person update(Long id, Person personDetails) {
        // Vérifie si la personne existe en base
        Person existingPerson = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found with id: " + id));

        // Mise à jour des informations
        existingPerson.setName(personDetails.getName());
        existingPerson.setCity(personDetails.getCity());
        existingPerson.setPhoneNumber(personDetails.getPhoneNumber());

        // Sauvegarde en base des modifications
        return personRepository.save(existingPerson);
    }

    /**
     * Supprime une personne de la base de données.
     *
     * @param id Identifiant de la personne à supprimer.
     * @throws ResourceNotFoundException si l'identifiant n'existe pas.
     */
    @Override
    public void delete(Long id) {
        // Vérifie si la personne existe avant suppression
        if (!personRepository.existsById(id)) {
            throw new ResourceNotFoundException("Person not found with id: " + id);
        }
        personRepository.deleteById(id);
    }
}
