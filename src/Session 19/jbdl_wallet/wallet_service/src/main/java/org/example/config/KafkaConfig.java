package org.example.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.constants.TopicConstants;
import org.example.dto.UserWalletCreationRequest;
import org.example.service.WalletOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Map;

@Configuration
@Slf4j
public class KafkaConfig {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WalletOperations walletOperations;

    @KafkaListener(topics = TopicConstants.USER_CREATION_TOPIC, groupId = "user_service.walletCreation")
    public void pollMessagesForUserCreation(ConsumerRecord receivedMessage) throws JsonProcessingException {
        UserWalletCreationRequest receivedData =  objectMapper.readValue(receivedMessage.value().toString(), UserWalletCreationRequest.class);
        log.info("ReceivedData: {}", receivedData.toString());
        walletOperations.createWalletForNewUser(receivedData);
    }
}
