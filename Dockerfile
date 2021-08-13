FROM tomcat:latest
LABEL maintainer="Vivek Raj"
ADD Calculator/target/TestCalculatorAppJuly21Batch.war /usr/local/tomcat/webapps/
EXPOSE 8010
CMD ["catalina.sh", "run"]
