package com.spring.boot.user.service.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Service
public class ChatProducerService {

    private final KafkaProducer<Integer, String> producer;
    Integer messageNo = 0;

    public ChatProducerService() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("client.id", "Admin");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<>(properties);
    }

    public void sendMessage(String message) throws ExecutionException, InterruptedException {
        producer.send(
                new ProducerRecord<>("user1-admin", messageNo++, message)
        ).get();
        System.out.println("Sent message to admin : " + message);
    }

    public void sendMessageUser2(String message) throws ExecutionException, InterruptedException {
        producer.send(
                new ProducerRecord<>("user1-user2", messageNo++, message)
        ).get();
        System.out.println("Sent message to user2 : " + message);
    }

    public void sendMessageUser1(String message) throws ExecutionException, InterruptedException {
        producer.send(
                new ProducerRecord<>("user2-user1", messageNo++, message)
        ).get();
        System.out.println("Sent message to user1 : " + message);
    }
}
