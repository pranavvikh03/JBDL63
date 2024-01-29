package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.constants.TopicConstants;
import org.example.dto.*;
import org.example.enums.PaymentStatus;
import org.example.entity.Transaction;
import org.example.enums.ServiceType;
import org.example.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
@Slf4j
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public UserTransactionResponse createTransactionRequest(UserTransactionRequest request) throws JsonProcessingException {
        Boolean senderExistCheck = restTemplate.getForObject("http://localhost:8081/wallet-users/userExistence/"+request.getSenderId(), Boolean.class);
        if(!senderExistCheck){
            log.info(String.format("Sender with id: %d Not Exist", request.getSenderId()));
            throw new RuntimeException(String.format("Sender with id: %d Not Exist", request.getSenderId()));
        }

        Boolean receiverExistCheck = restTemplate.getForObject("http://localhost:8081/wallet-users/userExistence/"+request.getReceiverId(), Boolean.class);
        if(Boolean.FALSE.equals(receiverExistCheck)){
            log.info(String.format("Receiver with id: %d Not Exist", request.getReceiverId()));
            throw new RuntimeException(String.format("Sender with id: %d Not Exist", request.getReceiverId()));
        }

        Double availableBalance = restTemplate.getForObject("http://localhost:8091/wallet-ops/fetchBalance/"+request.getSenderId(), Double.class);
        if(availableBalance < request.getAmount()){
            log.info("Insufficient Amount, Wallet Balance is: {}", availableBalance);
            throw new RuntimeException(String.format("Insufficient Amount, Wallet Balance is: " + availableBalance));
        }

        Transaction currentTransaction = new Transaction(request.getWalletId(), request.getSenderId(), request.getReceiverId(), request.getAmount());
        Transaction savedTransaction = transactionRepository.save(currentTransaction);

        InitiateTransactionDto initiateTransactionDtoRequest = InitiateTransactionDto.builder()
                .transactionId(savedTransaction.getTransactionId())
                .senderId(savedTransaction.getSenderId())
                .receiverId(savedTransaction.getReceiverId())
                .walletId(savedTransaction.getWalletId())
                .amount(savedTransaction.getAmount())
                .build();
        Future<SendResult<String, String>> send = kafkaTemplate.send(TopicConstants.INITIATE_TRANSACTION_TOPIC, savedTransaction.getTransactionId(), objectMapper.writeValueAsString(initiateTransactionDtoRequest));

        return UserTransactionResponse.builder()
                .transactionId(savedTransaction.getTransactionId())
                .message("Your Transaction is in Progress. Please wait")
                .status(PaymentStatus.PENDING)
                .paymentInitiationTime(savedTransaction.getPaymentInitiationDate())
                .build();
    }

    public void updateTransactionStatus(SuccessfulTransactionDto receivedData) {
        Transaction transaction = transactionRepository.findById(receivedData.getTransactionId()).get();
        transaction.setStatus(
                receivedData.getPaymentStatus().equals(PaymentStatus.SUCCESSFUL) ? PaymentStatus.SUCCESSFUL : PaymentStatus.REJECTED
        );
        transactionRepository.save(transaction);
    }

//    public void sendUserNotification(SuccessfulTransactionDto receivedData) {
//        Transaction transaction = transactionRepository.findById(receivedData.getTransactionId()).get();
//        String userEmailId = restTemplate.getForObject("http://localhost:8081/wallet-users/getUserDetails/"+transaction.getSenderId(), .class);
//        SendMailNotification sendMailNotification = SendMailNotification.builder()
//                .receiverMailId(receivedData.getUserEmailId())
//                .message(String.format(MailsTemplates.getWalletCreationMailBody().getMailBody(), receivedData.getUserName()))
//                .serviceType(ServiceType.WALLET_SERVICE)
//                .Subject(MailsTemplates.getWalletCreationMailBody().getMailSubject())
//                .build();
//        Future<SendResult<String, String>> send = kafkaTemplate.send(TopicConstants.SEND_NOTIFICATION_TOPIC, receivedData.getTransactionId(), objectMapper.writeValueAsString());
//    }
}
