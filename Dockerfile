FROM openjdk:8
EXPOSE 8055
ADD /target/timesheet-0.0.1.war timesheet.war
ENTRYPOINT ["java","-jar","timesheet.war"]