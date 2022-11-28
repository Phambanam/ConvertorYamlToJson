
FROM maven:3.6.0-jdk-11-slim AS build
COPY pom.xml /tmp
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn -f /tmp/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /tmp/target/Convertor_yaml_to_json-1.0.jar  /usr/local/lib/converter.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/converter.jar"]
