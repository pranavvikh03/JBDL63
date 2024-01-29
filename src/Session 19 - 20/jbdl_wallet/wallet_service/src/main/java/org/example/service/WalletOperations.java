package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.constants.TopicConstants;
import org.example.dto.InitiateTransactionDto;
import org.example.dto.SendMailNotification;
import org.example.dto.SuccessfulTransactionDto;
import org.example.dto.UserWalletCreationRequest;
import org.example.entity.Wallet;
import org.example.enums.PaymentStatus;
import org.example.enums.ServiceType;
import org.example.repository.WalletRepository;
import org.example.templates.MailsTemplates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
@Slf4j
public class WalletOperations {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void createWalletForNewUser(UserWalletCreationRequest receivedData) throws JsonProcessingException {
        long userId = receivedData.getUserId();
        Wallet newWallet = new Wallet(userId);
        log.info(String.format("New Wallet Details for User Id: %d are Wallet: %s", userId, newWallet.toString()));

        Wallet newCreatedWallet = walletRepository.save(newWallet);
        log.info(String.format("Saved Wallet Details for User Id: %d are Wallet: %s", userId, newCreatedWallet.toString()));

        SendMailNotification sendMailNotification = SendMailNotification.builder()
                .receiverMailId(receivedData.getUserEmailId())
                .message(String.format(MailsTemplates.getWalletCreationMailBody().getMailBody(), receivedData.getUserName()))
                .serviceType(ServiceType.WALLET_SERVICE)
                .Subject(MailsTemplates.getWalletCreationMailBody().getMailSubject())
                .build();
        Future<SendResult<String, String>> send = kafkaTemplate.send(TopicConstants.SEND_NOTIFICATION_TOPIC, newCreatedWallet.getUserId().toString(), objectMapper.writeValueAsString(sendMailNotification));
    }

    public Double fetchBalance(Long userId) {
        Wallet wallet = walletRepository.findByUserId(userId);
        return wallet.getBalance();
    }

    public void updateBalanceForUsers(InitiateTransactionDto receivedData) throws JsonProcessingException {
        Wallet senderWallet = walletRepository.findByUserId(receivedData.getSenderId());
        senderWallet.setBalance(senderWallet.getBalance() - receivedData.getAmount());
        walletRepository.save(senderWallet);

        Wallet receiverWallet = walletRepository.findByUserId(receivedData.getReceiverId());
        receiverWallet.setBalance(receiverWallet.getBalance() + receivedData.getAmount());
        walletRepository.save(receiverWallet);

        SuccessfulTransactionDto transactionDto = SuccessfulTransactionDto.builder()
                .transactionId(receivedData.getTransactionId())
                .paymentStatus(PaymentStatus.SUCCESSFUL)
                .build();
        Future<SendResult<String, String>> send = kafkaTemplate.send(TopicConstants.SUCCESSFUL_TRANSACTION_TOPIC, receivedData.getTransactionId(), objectMapper.writeValueAsString(transactionDto));
    }
}
