FROM openjdk:17-oracle
WORKDIR /app
EXPOSE 8080
ADD ./build/libs/RepeatBot-1.0.0.jar .
CMD ["java", "-jar", "RepeatBot-1.0.0.jar"]