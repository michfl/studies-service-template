# Getting Started

### About

This is a template for a simple Spring Boot app with AMQP support.

### First steps

#### Building and running using Gradle Wrapper

Make sure you have Java 18 JDK installed. You can get it [here](https://adoptium.net/temurin/releases/?version=18).
To build and run this project use the following commands in the main directory:
```
./gradlew build
./gradlew bootRun
```

#### Building and running in IntelliJ

Make sure you have 18 SDK selected in File -> Project structure -> Project.
Run the default Spring Boot configuration or start the application from Gradle or Services menu.

#### PostgreSQL

This project requires a Postgres DB. To be able to run it locally, 
use the following command to run the Postgres in Docker:
```
docker run -e POSTGRES_PASSWORD=password -p 5432:5432 --name template-db -d postgres:15
docker start template-db
```
Credentials are postgres:password.

#### RabbitMQ

To run RabbitMQ locally in Docker use the following commands:
```
docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management
```
Access RabbitMQ UI on http://localhost:15672. Credentials are guest:guest.

#### Swagger UI

Access Swagger UI on http://localhost:8080/swagger-ui.html

### Configure the application

This application has two Spring profiles defined:
* local - used by default (application-local.yaml)
* dev - switch by editing the run configuration and adding 'dev' to Active profiles (application-dev.yaml)

You can also run a selected profile from console using the command below:
```
./gradlew bootRun --args='--spring.profiles.active=dev'
```

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.5/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.5/gradle-plugin/reference/html/#build-image)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#howto.data-initialization.migration-tool.flyway)
* [Spring for RabbitMQ](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#messaging.amqp)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#actuator)

### Guides

The following guides illustrate how to use some features concretely:

* [Messaging with RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* [Getting started with RabbitMQ in Spring Boot](https://medium.com/javarevisited/getting-started-with-rabbitmq-in-spring-boot-6323b9179247)