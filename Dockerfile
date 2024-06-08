FROM openjdk:17-oracle
WORKDIR /app
EXPOSE 8080
ADD ./build/libs/RepeatBot-0.0.1.jar .
CMD ["java", "-jar", "RepeatBot-0.0.1.jar"]