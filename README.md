# Spring cloud stream demo

## Setup env

    $ curl -sSL https://raw.githubusercontent.com/bitnami/bitnami-docker-kafka/master/docker-compose.yml > docker-compose.yml
    $ docker-compose up -d

    # Create topic
    docker exec -it spring-cloud-stream-demo_kafka_1 kafka-topics.sh --create --bootstrap-server kafka:9092 --topic hello-stream
    
    # Verify the topic is working
    # Create events
    docker exec -it spring-cloud-stream-demo_kafka_1 kafka-console-producer.sh --bootstrap-server kafka:9092 --topic hello-stream
    # Read events
    docker exec -it spring-cloud-stream-demo_kafka_1 kafka-console-consumer.sh --bootstrap-server kafka:9092 --topic hello-stream --from-beginning

# Demo
## Stream by kafka binder
* Start publisher
* Start consumer

## Stream by kafka stream binder
* Start kafka-stream-publisher
* Start kafka-stream-consumer