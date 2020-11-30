FROM openjdk:latest

WORKDIR /factura-service
COPY ./target/facturamongo-0.0.1-SNAPSHOT.jar /factura-service

EXPOSE 8076

CMD ["java", "-jar", "facturamongo-0.0.1-SNAPSHOT.jar"]