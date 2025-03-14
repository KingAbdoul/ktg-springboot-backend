API CRUD pour l'entité "Person" - ktg-springboot-backend
Ce projet est une démonstration d'une application CRUD (Créer, Lire, Mettre à jour, Supprimer) réalisée avec Spring Boot, MySQL et Spring Data JPA. L'application gère une entité Person et expose des endpoints REST pour effectuer les opérations de base sur cette entité.

Table des Matières
Prérequis
Installation et Configuration
Exécution de l'Application
Endpoints de l'API
Collection Postman
Technologies Utilisées
Contribution
Prérequis
Avant de commencer, assurez-vous d'avoir installé les éléments suivants sur votre machine :

Java 21 (ou version supérieure compatible)
Maven
MySQL
Postman (optionnel, pour tester l'API)
Installation et Configuration
Cloner le dépôt :

bash
Copier
Modifier
git clone <URL_DU_REPO>
cd ktg-springboot-backend
Créer une base de données MySQL :

Connectez-vous à MySQL et exécutez la commande suivante :

sql
Copier
Modifier
CREATE DATABASE ktg_springboot_backend;
Configurer la connexion à la base de données :

Ouvrez le fichier src/main/resources/application.properties et ajustez les propriétés de connexion avec vos informations :

properties
Copier
Modifier
spring.application.name=ktg-springboot-backend

spring.datasource.url=jdbc:mysql://localhost:3306/ktg_springboot_backend
spring.datasource.username=katong
spring.datasource.password=katongorond
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
Installer les dépendances et construire le projet :

Dans le répertoire du projet, exécutez :

bash
Copier
Modifier
mvn clean install
Exécution de l'Application
Pour lancer l'application Spring Boot, utilisez la commande suivante :

bash
Copier
Modifier
mvn spring-boot:run
L'application démarrera sur http://localhost:8080.

Endpoints de l'API
Les endpoints suivants permettent de gérer l'entité Person :

GET /api/persons
Récupérer la liste de toutes les personnes.

GET /api/persons/{id}
Récupérer une personne par son identifiant.

POST /api/persons
Créer une nouvelle personne.

Exemple de corps de requête :

json
Copier
Modifier
{
    "name": "John Doe",
    "city": "Los Angeles",
    "phoneNumber": "999-777-444"
}
PUT /api/persons/{id}
Mettre à jour une personne existante par son identifiant.

Exemple de corps de requête :

json
Copier
Modifier
{
    "city": "New York",
    "phoneNumber": "999-777-444"
}
DELETE /api/persons/{id}
Supprimer une personne par son identifiant.

Collection Postman
Une collection Postman est fournie à la racine du projet pour faciliter les tests de l'API. Vous pouvez importer ce fichier dans Postman pour exécuter rapidement chacun des endpoints.

Technologies Utilisées
Spring Boot : Framework facilitant la création d'applications Java autonomes.
Spring Data JPA : Simplifie l'implémentation des repositories JPA pour la persistance.
MySQL : Système de gestion de base de données relationnelle.
Maven : Outil de gestion et de build pour les projets Java.
Postman : (Optionnel) Outil pour tester et documenter l'API.
