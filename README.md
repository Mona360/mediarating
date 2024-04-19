# Starten
docker compose -f docker-compose-mssql-2022.yml up -d
docker compose -f docker-compose-service.yml up

# Stoppen
^C für service (ohne -d gestarted)

docker compose -f docker-compose-mssql-2022.yml down