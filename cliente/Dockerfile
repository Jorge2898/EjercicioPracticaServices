FROM openjdk:latest

WORKDIR /cliente-service
COPY ./target/cliente-0.0.1-SNAPSHOT.jar /cliente-service

EXPOSE 8070

CMD ["java", "-jar", "cliente-0.0.1-SNAPSHOT.jar"]