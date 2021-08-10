FROM tomcat:latest
LABEL maintainer="Vivek Raj"
ADD ./target/TestCalculatorAppJuly21Batch.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
