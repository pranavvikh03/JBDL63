package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.UserResponseDto;
import org.example.model.User;
import org.example.service.UserOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet-users")
@Slf4j
@Validated
public class UserController {

    @Autowired
    private UserOperationsService userOperationsService;
    @PostMapping
    public ResponseEntity<UserResponseDto> createNewUser(@RequestBody @Valid User user) {
        try{
            return new ResponseEntity<>(userOperationsService.createUserAccount(user), HttpStatus.CREATED);
        }
        catch(RuntimeException e) {
            log.error(String.format("Runtime Exception occured for userId: %d Exception is :%s", user.getUserId(), e.getMessage()));
        } catch (Exception e) {
            log.error(String.format(" Exception occured for userId: %d Exception is :%s", user.getUserId(), e.getMessage()));
        }
        return null;
    }
}
