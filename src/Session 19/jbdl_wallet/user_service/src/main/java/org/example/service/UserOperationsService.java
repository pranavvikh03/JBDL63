package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.constants.TopicConstants;
import org.example.dto.UserResponseDto;
import org.example.dto.UserWalletCreationRequest;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.Future;

@Service
@Slf4j
public class UserOperationsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public UserResponseDto createUserAccount(User user) throws JsonProcessingException {
        User savedUser = userRepository.save(user);
        log.info(String.format("User account is created for UserId: %d and UserName: %s", savedUser.getUserId(), savedUser.getUserFullName()));

        UserWalletCreationRequest userWalletCreationRequest = UserWalletCreationRequest.builder()
                .userId(savedUser.getUserId())
                .userName(savedUser.getUserFullName())
                .userEmailId(savedUser.getUserEmailId())
                .build();
        Future<SendResult<String, String>> send = kafkaTemplate.send(TopicConstants.USER_CREATION_TOPIC, savedUser.getUserId().toString(), objectMapper.writeValueAsString(userWalletCreationRequest));

        return UserResponseDto.builder()
                .message("User account is created, Wallet creation is in progress. We will notify you over mail once done")
                .user(savedUser)
                .build();
    }
}
