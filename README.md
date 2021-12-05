1) Start Zookeeper :
   `.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties`

2) Start Kafka server:
   `.\bin\windows\kafka-server-start.bat .\config\server.properties`

   To Stop Kafka Server
   `.\bin\windows\kafka-server-stop.bat .\config\server.properties`

3) To view list of Kafka-topics
   `.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092`

4) To create a new topic
   `.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic chat-app-topic`

6) To start build in console producer:
   `.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic chat-app-topic`

7) To start build in console Consumer:
   `.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic chat-app-topic --from-beginning`