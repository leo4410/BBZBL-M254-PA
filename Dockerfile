FROM openjdk:11-jdk

FROM openjdk:11-jdk
ARG MAVEN_VERSION=3.8.1
WORKDIR /usr/local/bin
COPY /target/*.jar demo.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]