package com.trungvq.kafkaexample.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "topic-sample",
            groupId = "group-sample"
    )
    public void listener(String data) {
        System.out.println("Listener received data: " + data);
    }
}
