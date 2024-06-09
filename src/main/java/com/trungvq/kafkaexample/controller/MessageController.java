package com.trungvq.kafkaexample.controller;

import com.trungvq.kafkaexample.model.Message;
import com.trungvq.kafkaexample.request.MessageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    private KafkaTemplate<String, Message> kafkaTemplate;

    public MessageController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publishMessage(@RequestBody MessageRequest messageRequest) {
        Message message = new Message(messageRequest.message(), LocalDateTime.now());
        kafkaTemplate.send("topic-sample", message);
    }
}
