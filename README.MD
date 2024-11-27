# Spring Boot application with Redis in persistence layer

[![Java CI with Maven](https://github.com/andrei-punko/spring-boot-redis/actions/workflows/maven.yml/badge.svg)](https://github.com/andrei-punko/spring-boot-redis/actions/workflows/maven.yml)
[![Coverage](.github/badges/jacoco.svg)](https://github.com/andrei-punko/spring-boot-redis/actions/workflows/maven.yml)
[![Branches](.github/badges/branches.svg)](https://github.com/andrei-punko/spring-boot-redis/actions/workflows/maven.yml)

Based on [Spring Boot app template](https://github.com/andrei-punko/spring-boot-3-template)

Includes web-server on port 9080 with `/api/v1/articles` endpoint exposed.  
Supports CRUD set of operations and R with pagination

## Prerequisites:

- Maven 3
- JDK 21

## How to build:

```shell
mvn clean install
```

### Build Docker image with application inside:

```shell
docker build --no-cache ./ -t spring-boot-redis-app
```

## Start application using starting script:

Use [run-in-docker.bat](run-in-docker.bat) script

## Start application by running executable jar (Redis should be started before that manually):

    java -jar target/spring-boot-redis-0.0.1-SNAPSHOT.jar \
     --spring.redis.host=localhost \
     --spring.redis.port=6379

## Same thing but using Spring profile to determine properties (Redis should be started before that manually):

    java -jar target/spring-boot-redis-0.0.1-SNAPSHOT.jar \
     --spring.profiles.active=dev

## Start application using Maven (Redis should be started before that manually):

    mvn spring-boot:run -Dspring-boot.run.arguments="\
     --spring.redis.host=localhost \
     --spring.redis.port=6379

## Same thing but using Spring profile to determine properties (Redis should be started before that manually):

    mvn spring-boot:run -Dspring-boot.run.arguments=--spring.profiles.active=dev

## Start application using set of two Docker containers - one with Redis and another with application:

    docker-compose up

## Link for quick check:

http://localhost:9080/api/v1/articles

## Swagger documentation:

http://localhost:9080/swagger-ui/index.html

## Useful CURL commands:

### New article addition:

```shell
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -d '{ "title": "Some tittle", "text": "Some text", "summary": "bla-bla", "author": "Pushkin" }' -X POST http://localhost:9080/api/v1/articles
```

### Get existing article:

```shell
curl -i http://localhost:9080/api/v1/articles/1
```

### Update existing article:

```shell
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -d '{ "title": "Another tittle" }' -X PATCH http://localhost:9080/api/v1/articles/2
```

### Get all articles:

```shell
curl -i http://localhost:9080/api/v1/articles
```

### Get list of articles with pagination support:

```shell
curl -i 'http://localhost:9080/api/v1/articles?size=2&page=4&sort=author.firstName,DESC'
```

### Deletion of article:

```shell
curl -i -X DELETE http://localhost:9080/api/v1/articles/1
```

## Run functional tests:

    cd func-test
    ./gradlew clean build

Check functional test report [here](func-test/build/spock-reports/index.html)
