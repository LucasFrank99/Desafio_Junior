
FROM openjdk:21-jdk-slim
LABEL authors="lucas"

WORKDIR /app

COPY target/transacao-0.0.1-SNAPSHOT.war app.war

ENTRYPOINT ["java", "-war", "app.war"]