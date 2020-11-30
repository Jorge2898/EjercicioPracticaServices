FROM openjdk:latest

WORKDIR /pago-server
COPY ./target/PagoMongo-0.0.1-SNAPSHOT.jar /pago-server

EXPOSE 8077


CMD ["java", "-jar", "PagoMongo-0.0.1-SNAPSHOT.jar"]