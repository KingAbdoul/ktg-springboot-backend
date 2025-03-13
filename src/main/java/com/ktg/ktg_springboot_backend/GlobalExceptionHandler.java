package com.ktg.ktg_springboot_backend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe de gestion globale des exceptions dans l'application Spring Boot.
 * L'annotation @ControllerAdvice permet d'intercepter les exceptions et
 * de renvoyer des réponses appropriées à l'utilisateur.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Gestionnaire d'exception pour les cas où une ressource n'est pas trouvée.
     * Intercepte les exceptions de type ResourceNotFoundException et renvoie une réponse structurée.
     *
     * @param ex       L'exception levée lorsque la ressource demandée est introuvable.
     * @param request  L'objet WebRequest contenant les détails de la requête HTTP.
     * @return         Une réponse HTTP 404 (Not Found) avec un corps détaillé.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());  // Ajoute la date et l'heure de l'erreur
        body.put("status", HttpStatus.NOT_FOUND.value());  // Code HTTP 404
        body.put("error", "Not Found");  // Description de l'erreur
        body.put("message", ex.getMessage());  // Message spécifique de l'exception
        body.put("path", request.getDescription(false).replace("uri=", ""));  // URL de la requête

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    /**
     * Gestionnaire global pour toutes les autres exceptions non spécifiquement traitées.
     * Intercepte toute exception de type Exception et renvoie une réponse structurée.
     *
     * @param ex       L'exception levée.
     * @param request  L'objet WebRequest contenant les détails de la requête HTTP.
     * @return         Une réponse HTTP 500 (Internal Server Error) avec un corps détaillé.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());  // Ajoute la date et l'heure de l'erreur
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());  // Code HTTP 500
        body.put("error", "Internal Server Error");  // Description de l'erreur
        body.put("message", ex.getMessage());  // Message spécifique de l'exception
        body.put("path", request.getDescription(false).replace("uri=", ""));  // URL de la requête

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
