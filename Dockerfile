FROM openjdk:21

VOLUME /tmp

COPY target/*.jar Hotel-0.0.1-SNAPSHOT.jar

EXPOSE 45397
ENTRYPOINT ["java","-jar","/Hotel-0.0.1-SNAPSHOT.jar"]