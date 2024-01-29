package org.example.controller;

import org.example.service.WalletOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet-ops")
public class WalletController {

    @Autowired
    private WalletOperations walletOperations;

    @GetMapping("/fetchBalance/{id}")
    public ResponseEntity<Double> getBalance(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(walletOperations.fetchBalance(userId), HttpStatus.OK);
    }
}
