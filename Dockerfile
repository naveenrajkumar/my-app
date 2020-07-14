FROM gradle:jdk8 AS GRADLE_BUILD

MAINTAINER Naveen R

COPY build.gradle /build/
COPY src /build/src/
COPY *gradle* /build/
COPY .git /build/


WORKDIR /build/
RUN gradle build

FROM openjdk:8-jre-alpine

WORKDIR /app

COPY --from=GRADLE_BUILD /build/build/libs/my-app-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "my-app-0.0.1-SNAPSHOT.jar"]
