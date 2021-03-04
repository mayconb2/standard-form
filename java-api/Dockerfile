# FROM maven:3.6.1-jdk-8-slim AS build
# RUN mkdir -p /workspace
# WORKDIR /workspace
# COPY pom.xml /workspace
# COPY src /workspace/src
# # RUN mvn -f pom.xml clean package

# FROM openjdk:8-alpine
# COPY --from=build /workspace/target/*.jar app.jar
# EXPOSE 8090
# ENTRYPOINT ["java","-jar","app.jar"]

# standard-form-0.0.1-SNAPSHOT.jar

 
FROM openjdk:8-alpine
ADD target/standard-form-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]