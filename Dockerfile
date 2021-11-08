FROM java:8
EXPOSE 8094
ADD /target/timesheet-0.0.1.war timesheet.jar
ENTRYPOINT ["java","-jar","timesheet.jar"]