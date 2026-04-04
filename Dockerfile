FROM eclipse-temurin:25-jdk as builder
COPY . .
RUN ./mvnw clean package

FROM eclipse-temurin:25-jre as executor
COPY --from=builder /target/app.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
