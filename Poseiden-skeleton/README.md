# Poseidon
## Technical:

1. Framework: Spring Boot v2.6.7
2. Java 17
3. Thymeleaf
4. Bootstrap v.4.3.1

##General Info

Financial transactions application for Poseidon Inc
Project 7 of Java Application Developper Course

## Installation
1. Clone the repository: git clone https://github.com/BenCorpro/JavaDA_PROJECT7_RESTAPI
2. Get into the project folder: cd ../path/to/the/file
3. Package the application: mvn package -DskipTests=true (to skip the tests since tests needs connection to a test database, and properties are externalized)
4. Copy the application.properties file (in doc folder) in a "config" folder, and copy the jar next to it (for database id and password)
5. Execute the jar: java -jar spring-boot-skeleton-0.0.1-SNAPSHOT.jar
6. Go to [http://localhost:8080](http://localhost:8080) on your browser
7. Side information: To use the application database needs to be filled with at least a pre-existing user
