[![CircleCI](https://circleci.com/gh/JohnneSouza/webportal/tree/master.svg?style=svg)](https://circleci.com/gh/JohnneSouza/webportal/tree/master)

# WebPortal

This project was build as a graduation requeriment, a JAVA API built using the [Spring Famework](https://spring.io) and [Reactive Programming](https://www.reactivemanifesto.org).

This application manages the data from a real state business.

## Prerequisites

To run this project properly on your local machine, you will need:

* `Java 8` or Superior
* `Maven`
* `MongoDB`
* `Postman`

## Getting Started

These instructions will get you to run and use the project on your local machine, for development and testing.

Clone the repository and run the  command:

```
mvn spring-boot:run
```

The application will start on the `port:8080` on your machine.

This application has a [Dockerfile](https://github.com/JohnneSouza/webportal/blob/master/Dockerfile) include, if you are familiar with Docker you can build the file and try the API.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Framework](https://spring.io) - Application Framework
  * [Reactor](https://projectreactor.io/) - Reactive Library
  * [Swagger](https://swagger.io/) - Documentation Library
* [CircleCI](https://circleci.com/) - Continuous integration and delivery platform
* [MongoDB](https://www.mongodb.com/) - Data Repository
* [Docker](https://www.docker.com/) - Containerization and share

## License

This API has a [General Public License](https://www.gnu.org/licenses/gpl-3.0.en.html), so you can copy and modify this project at your will.

For more details see the [LICENSE](https://github.com/JohnneSouza/webportal/blob/master/LICENSE).