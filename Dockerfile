FROM tomcat:latest
LABEL maintainer="Vivek Raj"
ADD Calculator/target/TestCalculatorAppJuly21Batch.war /usr/local/tomcat/webapps/
EXPOSE 9010
CMD ["catalina.sh", "run"]
