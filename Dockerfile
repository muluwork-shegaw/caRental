FROM openjdk:17
RUN mkdir /app
COPY target/CarRental-0.0.1-SNAPSHOT.jar /app
WORKDIR /app
CMD ["java", "-jar", "./CarRental-0.0.1-SNAPSHOT.jar"]