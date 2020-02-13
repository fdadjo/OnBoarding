# Pull base image.
FROM java:8

# Author of the image.
MAINTAINER f.dadjo@pkf-researchcenter.com
# Define working directory.
WORKDIR /data
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /data/
COPY run.sh /data/
EXPOSE 8080
ENTRYPOINT ["./run.sh"]
