FROM openjdk:8-jdk

LABEL maintainer="muk214782@gmail.com"

WORKDIR /app

COPY target/m_gateway-0.0.1-SNAPSHOT.jar /app/m_gateway-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "m_gateway-0.0.1-SNAPSHOT.jar"]