FROM openjdk:17-alpine

VOLUME /tmp

COPY target/userapp.jar userapp.jar

ENTRYPOINT ["java", "-jar", "userapp.jar"]