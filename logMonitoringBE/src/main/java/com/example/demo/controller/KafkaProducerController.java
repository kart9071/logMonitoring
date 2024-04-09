package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.KafkaProducerService;


@RestController
@RequestMapping("/api")
public class KafkaProducerController {

    private final KafkaProducerService kafkaProducerService;

    @Autowired
    private KafkaProducerController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/send-message")
    public void sendMessageToKafka(@RequestBody String message) {
        String topic = "my-topic";
        kafkaProducerService.sendMessage(topic, message);
    }
    
}
