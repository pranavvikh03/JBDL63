package com.apacheKafka.ApacheKafkaDemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    @KafkaListener(topics = "jbdl63-demo", groupId = "jbdlPractice-1")
    public void listenMessage(String message) {
        System.out.println(message);
    }
}
