FROM alpine/git as clone
WORKDIR /app
# Modify /template to your project name
# $GITHUB_SERVER_URL/$GITHUB_REPOSITORY
RUN git clone https://github.com/dgarbar/template-java.git

FROM maven:3.6.3-jdk-11-slim AS build
WORKDIR /app
# Modify /template-java to your project name
COPY --from=clone /app/template-java /app
RUN mvn -Dmaven.test.skip=true clean package

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/template.jar /app
EXPOSE 8080
CMD ["java", "-jar", "template.jar"]