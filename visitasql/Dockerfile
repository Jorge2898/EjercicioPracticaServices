FROM openjdk:latest

WORKDIR /visita-service
COPY ./target/visitasql-0.0.1-SNAPSHOT.jar /visita-service

EXPOSE 8078

CMD ["java", "-jar", "visitasql-0.0.1-SNAPSHOT.jar"]