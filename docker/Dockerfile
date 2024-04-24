# Primera etapa - Compilar y empaquetar la aplicación
FROM docker.io/library/maven:3.8.1-openjdk-17-slim AS build
WORKDIR /app
COPY ../pom.xml .
RUN mvn dependency:go-offline
COPY ../src /app/src/
RUN mvn package -DskipTests

# Segunda etapa - Ejecutar la aplicación
FROM docker.io/library/eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
EXPOSE 8080
