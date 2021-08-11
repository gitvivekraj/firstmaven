FROM tomcat:latest
LABEL maintainer="Vivek Raj"
ADD Calculator/target/TestCalculatorAppJuly21Batch.war /usr/local/tomcat/webapps/
EXPOSE 8090
CMD ["catalina.sh", "run"]
