FROM eclipse-temurin:22_36-jre-alpine

ADD /target/coin-0.0.1-SNAPSHOT.jar /coin.jar


# COPY ${/target/coin-0.0.1-SNAPSHOT.jar} /coin.jar


ENTRYPOINT [ "java", "-jar", "/coin.jar" ]

