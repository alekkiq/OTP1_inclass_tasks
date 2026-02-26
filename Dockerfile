FROM maven:3.9.6-eclipse-temurin-21 AS build
LABEL authors="aleksput"

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn package -DskipTests --no-transfer-progress

FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]