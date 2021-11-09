FROM openjdk:8
EXPOSE 8086
ADD /target/timesheet-0.0.1.war timesheet.jar
ENTRYPOINT ["java","-jar","timesheet.jar"]