FROM openjdk
MAINTAINER Jay Jay
ARG JAR_FILE
COPY ${JAR_FILE} crud-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/crud-0.0.1-SNAPSHOT.jar"]