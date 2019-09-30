FROM openjdk:8-jdk-alpine

ARG VERSION

ADD ./target/webportal.jar /webportal.jar

ENTRYPOINT ["java","-jar","webportal.jar"]