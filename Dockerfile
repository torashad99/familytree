FROM openjdk:11

WORKDIR /app
ADD --chown=gradle:gradle ./ /app

RUN ./gradlew build

ARG JAR_FILE=build/libs/demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]