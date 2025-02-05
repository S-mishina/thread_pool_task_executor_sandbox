FROM openjdk:23 as builder
COPY sandbox-app .
RUN ./mvnw clean package
FROM eclipse-temurin:23-jre as executor
COPY --from=builder /target/app.jar /app.jar
