FROM java:8
EXPOSE 8085
ADD /target/timesheet-0.0.1.war timesheet.jar
ENTRYPOINT ["java","-jar","timesheet.jar"]