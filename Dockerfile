# Example Dockerfile for a Spring Boot/Java app
FROM eclipse-temurin:17-jdk-alpine
COPY target/HMS*.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080