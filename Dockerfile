FROM maven:3.6.0-jdk-11-slim

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y git

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app/FoodTruckFinder/

CMD cd /app/FoodTruckFinder ; mvn package ; java -jar target/Food*-jar-with-dependencies.jar
