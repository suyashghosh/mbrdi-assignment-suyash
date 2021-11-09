# mbrdi-assignment-suyash
mbrdi online assignment

## Prerequisites
- Install Java8 or higher
- Install Kafka (https://archive.apache.org/dist/kafka/2.7.0/kafka-2.7.0-src.tgz)
- Install Zookeeper

## Project Setup
- Start the zookeeper server
    ```sh
    bin/zookeeper-server-start.sh config/zookeeper.properties
    ```
- Open a new terminal window and start Kafka server
    ```sh
    bin/kafka-server-start.sh config/server.properties
    ```
- The kafka server starts on port `9092` by default.    
- Open a new terminal window and create Kafka topic with name Kafka_Example
    ```sh
    bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic Kafka_Example
    ```
- Clone the git repository and import both the services as maven projects in your IDE.
- Right click on the projects and select Maven Update Project so that all dependencies are downloaded
- Run both projects as Springboot Applications. Counsumer-facing service runs on port `8100` and File-handling service runs on port `8200`
- Once the applications starts up you can find the api swagger documentation in this link http://localhost:8100/swagger-ui.html or you can even test it via postman.