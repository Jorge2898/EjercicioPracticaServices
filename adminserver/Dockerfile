FROM openjdk:latest

WORKDIR /admin-server
COPY ./target/adminserver-0.0.1-SNAPSHOT.jar /admin-server

EXPOSE 8761


CMD ["java", "-jar", "adminserver-0.0.1-SNAPSHOT.jar"]