# Getting Started

### About

This is a template for a simple Spring Boot app with AMQP support.

### Starting in local

#### PostgreSQL

This project requires a Postgres DB. To be able to run it locally, 
use the following command to run the Postgres image on Docker (postgres:password):
```
docker run -e POSTGRES_PASSWORD=password -p 5432:5432 --name template-db -d postgres:15
docker start template-db
```

#### RabbitMQ

To run RabbitMQ locally use the following commands (guest:guest):
```
docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management
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