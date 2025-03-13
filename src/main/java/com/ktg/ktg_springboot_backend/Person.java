package com.ktg.ktg_springboot_backend;

// Importation des annotations JPA pour la gestion des entités.
import jakarta.persistence.*;

// L'annotation @Entity indique que cette classe représente une entité qui sera mappée dans la base de données.
@Entity
// L'annotation @Table spécifie le nom de la table associée à cette entité. Ici, la table s'appelle "Persons".
@Table(name = "Persons")
public class Person {

    // L'annotation @Id indique que le champ suivant est la clé primaire de l'entité.
    @Id
    // L'annotation @GeneratedValue définit la stratégie de génération de la valeur de l'ID.
    // Ici, GenerationType.IDENTITY indique que la base de données générera automatiquement la valeur.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique de la personne.

    private String name;        // Le nom de la personne.
    private String city;        // La ville de résidence de la personne.
    private String phoneNumber; // Le numéro de téléphone de la personne.

    /**
     * Getter pour l'attribut id.
     * @return l'identifiant de la personne.
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter pour l'attribut id.
     * @param id l'identifiant à assigner à la personne.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter pour l'attribut name.
     * @return le nom de la personne.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter pour l'attribut name.
     * @param name le nom à assigner à la personne.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter pour l'attribut city.
     * @return la ville de résidence de la personne.
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter pour l'attribut city.
     * @param city la ville à assigner à la personne.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter pour l'attribut phoneNumber.
     * @return le numéro de téléphone de la personne.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter pour l'attribut phoneNumber.
     * @param phoneNumber le numéro de téléphone à assigner à la personne.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
