package com.ktg.ktg_springboot_backend;

/**
 * Exception personnalisée pour gérer les ressources non trouvées.
 * Hérite de RuntimeException pour éviter d'avoir à la gérer explicitement avec try-catch.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructeur qui prend un message d'erreur en paramètre.
     *
     * @param message Message expliquant la raison de l'exception.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
