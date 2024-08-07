FROM          ubuntu:22.04
MAINTAINER    Sven Walsted "swalsted@gmail.com"
#######################################################################################################
# docker build -t swalsted/springboot-forms-ubuntu22.04:latest .
#
# docker run --name springboot-forms -d --rm -p 2112:8080 swalsted/springboot-forms-ubuntu22.04:latest
#
#######################################################################################################
RUN           apt update
RUN           apt install openjdk-19-jre-headless -y
COPY          target/forms-0.0.2-SNAPSHOT.war /tmp
CMD           java -jar /tmp/forms-0.0.2-SNAPSHOT.war