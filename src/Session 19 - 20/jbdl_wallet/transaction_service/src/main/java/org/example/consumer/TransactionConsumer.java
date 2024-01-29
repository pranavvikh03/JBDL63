package org.example.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.constants.TopicConstants;
import org.example.dto.SuccessfulTransactionDto;
import org.example.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class TransactionConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TransactionService transactionService;

    @KafkaListener(topics = TopicConstants.SUCCESSFUL_TRANSACTION_TOPIC, groupId = "successful_transactions")
    public void pollSuccessfulOrFailureTransaction(ConsumerRecord receivedMessage) throws JsonProcessingException {
        SuccessfulTransactionDto receivedData =  objectMapper.readValue(receivedMessage.value().toString(), SuccessfulTransactionDto.class);
        transactionService.updateTransactionStatus(receivedData);
//        transactionService.sendUserNotification(receivedData);
    }
}
