FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_vliloks_javanews_bot
ENV BOT_TOKEN=2078960256:AAGKj9yYhpjB9OJW3lh5eUarHFXEpghbNoE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]