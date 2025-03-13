package com.ktg.ktg_springboot_backend;

// Import de l'interface JpaRepository de Spring Data JPA qui fournit les opérations CRUD de base.
import org.springframework.data.jpa.repository.JpaRepository;
// Annotation pour indiquer que cette interface est un bean de type Repository, et donc gérée par Spring.
import org.springframework.stereotype.Repository;

/**
 * Repository pour l'entité Person.
 * Cette interface étend JpaRepository, ce qui lui permet d'hériter de méthodes CRUD (Create, Read, Update, Delete)
 * ainsi que de fonctionnalités de pagination et de tri.
 *
 * Les paramètres génériques sont :
 * - Person : l'entité concernée.
 * - Long   : le type de la clé primaire de l'entité Person.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    // Vous pouvez définir ici des méthodes de requête supplémentaires si besoin,
    // par exemple : List<Person> findByCity(String city);
}
