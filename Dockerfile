FROM openjdk:23 as builder
COPY . .
RUN ./mvnw clean package
FROM eclipse-temurin:23-jre as executor
COPY --from=builder /target/app.jar /app.jar
