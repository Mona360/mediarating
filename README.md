# Build Images
The application can run locally and in docker.
Build docker images for both application.

## Server Image
<pre>
cd server
gradlew buildImage
</pre>

## Angular App Image
<pre>
cd angular
docker build . --tag "local/hatoka/mediarating-app:latest"
</pre>

# Starten
* docker compose -f docker-compose-mssql-2022.yml up -d
* docker compose -f docker-compose-service.yml up

# Stoppen
 * Strg C für service (ohne -d gestartet)
 * docker compose -f docker-compose-mssql-2022.yml down

# wichtige Links
* Dokumentation Rest API http://localhost:9090/actuator/swagger-ui

# Noch zu erledigen

* Neue Node Version: 18
* Papas Code nachvollziehen
* eigentliches Projekt starten
* angular app without authentication

