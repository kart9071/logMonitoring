package com.example.demo.service;

import java.util.Collections;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.common.KafkaFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.Properties;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final AdminClient adminclient;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate,AdminClient adminclient) {
        this.kafkaTemplate = kafkaTemplate;
        this.adminclient=adminclient;
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
    
//    public void createTopicIfNotExist(String topicName,int partition,short replicationFactor) {
//    	DescribeTopicsResult describeTopic = adminclient.describeTopics(Collections.singletonList(topicName));
//        KafkaFuture<Map<String, TopicDescription>> topicDescriptionFuture = describeTopic.values().get(topicName);
//        try {
//            TopicDescription topicDescription = topicDescriptionFuture.get().get(topicName);
//            if (topicDescription == null) {
//                // Topic does not exist, create it
//                NewTopic newTopic = new NewTopic(topicName, partition, replicationFactor);
//                adminclient.createTopics(Collections.singletonList(newTopic));
//                System.out.println("Topic created successfully: " + topicName);
//            } else {
//                System.out.println("Topic already exists: " + topicName);
//            }
//        } catch (Exception e) {
//            System.err.println("Error while creating or describing topic: " + e.getMessage());
//        }
//    }
    
}

