FROM maven:3.9.9-eclipse-temurin-21 AS build  
WORKDIR /project
COPY . /project/
RUN mvn clean package
EXPOSE 9400
CMD ["mvn", "exec:java", "-Dexec.mainClass=sap.observability.TestProm" ]