package com.trungvq.kafkaexample.listener;

import com.trungvq.kafkaexample.model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "topic-sample",
            groupId = "group-sample 4",
            containerFactory = "messageFactory"
    )
    public void listener(Message data) {
        System.out.println("Listener received data: " + data);
    }
}
