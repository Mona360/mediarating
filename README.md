# Starten
docker compose -f docker-compose-mssql-2022.yml up -d
docker compose -f docker-compose-service.yml up

# Stoppen
 Strg C für service (ohne -d gestartet)
docker compose -f docker-compose-mssql-2022.yml down

Neue Node Version: 18