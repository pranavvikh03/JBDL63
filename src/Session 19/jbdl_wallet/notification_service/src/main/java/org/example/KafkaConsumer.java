package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.constants.TopicConstants;
import org.example.dto.SendMailNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@Slf4j
public class KafkaConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SendMail sendMail;

    @KafkaListener(topics = TopicConstants.SEND_NOTIFICATION_TOPIC, groupId = "send_notification")
    public void sendNotification(ConsumerRecord receivedMessage) throws JsonProcessingException {
        SendMailNotification d = objectMapper.readValue(receivedMessage.value().toString(), SendMailNotification.class);
        log.info(String.format("Received Notification from Service: %s with Message: %s", d.getServiceType().name(), d.toString()));
        sendMail.sendMail(d);
    }
}
