package com.jbdl63.AnnotationImpl.controller;

import com.jbdl63.AnnotationImpl.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/banks")
    public ResponseEntity<List<String>> getBankName() {
        try{
            return new ResponseEntity<>(bankService.fetchBankName(), HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(List.of(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/banks/{id}")
    public ResponseEntity<String> getBankName(@PathVariable("id") Integer id) {
        try{
            return new ResponseEntity<>(bankService.getBankNameById(id), HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
