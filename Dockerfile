# Dockerfile
#
## Use Maven image to build the project
#FROM maven:3.8.5-openjdk-17 AS build
#
## Set the working directory
#WORKDIR /app
#
## Copy the pom.xml and source code into the container
#COPY pom.xml .
#COPY src ./src
#
## Compile and package the application
#RUN mvn clean package -DskipTests
#
## Use OpenJDK image to run the app
#FROM openjdk:17-jdk
#
## Set the working directory in the container
#WORKDIR /app
#
## Copy the jar file from the previous stage
#COPY --from=build /app/target/olympic-0.0.1-SNAPSHOT.jar springboot-app.jar
#
## Expose the port the app will run on
#EXPOSE 8080
#
## Run the Spring Boot application
#CMD ["java", "-jar", "springboot-app.jar"]
