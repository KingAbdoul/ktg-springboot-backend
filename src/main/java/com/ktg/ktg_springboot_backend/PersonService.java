package com.ktg.ktg_springboot_backend;

import java.util.List;
import java.util.Optional;

/**
 * Interface définissant les opérations métier pour l'entité Person.
 * Cette interface sert de contrat pour la gestion des personnes,
 * en séparant la logique métier du contrôleur.
 */
public interface PersonService {

    /**
     * Récupère la liste complète des personnes enregistrées.
     *
     * @return Liste contenant toutes les personnes.
     */
    List<Person> findAll();

    /**
     * Recherche une personne par son identifiant.
     *
     * @param id Identifiant unique de la personne.
     * @return Un objet Optional contenant la personne si elle est trouvée,
     *         sinon un Optional vide.
     */
    Optional<Person> findById(Long id);

    /**
     * Enregistre une nouvelle personne dans la base de données.
     *
     * @param person Objet Person à enregistrer.
     * @return La personne sauvegardée avec son identifiant généré.
     */
    Person save(Person person);

    /**
     * Met à jour les informations d'une personne existante.
     *
     * @param id Identifiant de la personne à mettre à jour.
     * @param personDetails Nouvelles informations de la personne.
     * @return L'objet Person mis à jour.
     */
    Person update(Long id, Person personDetails);

    /**
     * Supprime une personne de la base de données.
     *
     * @param id Identifiant de la personne à supprimer.
     */
    void delete(Long id);
}
