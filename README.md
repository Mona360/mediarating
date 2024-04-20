# Starten
docker compose -f docker-compose-mssql-2022.yml up -d
docker compose -f docker-compose-service.yml up

# Stoppen
 Strg C für service (ohne -d gestartet)
docker compose -f docker-compose-mssql-2022.yml down

# wichtige Links
Dokumentation Rest API http://localhost:9090/actuator/swagger-ui

# Noch zu erledigen
Neue Node Version: 18
Papas Code nachvollziehen
eigentliches Projekt starten