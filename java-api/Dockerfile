FROM maven:3.6.1-jdk-8-slim as build

ADD . ./workspace
WORKDIR /workspace

RUN mvn clean install

FROM openjdk:8-alpine

COPY --from=build /workspace//target/standard-form-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
