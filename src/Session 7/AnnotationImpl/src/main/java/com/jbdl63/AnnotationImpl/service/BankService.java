package com.jbdl63.AnnotationImpl.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BankService {

    private Map<Integer, String> mp = Map.of(1, "SBI", 2,"Bank of Baroda");

    public List<String> fetchBankName() {
        if(mp.isEmpty())
            throw new RuntimeException("No Banks Available");
        List<String> bankList = new ArrayList<>();
        for(Map.Entry<Integer, String> m : mp.entrySet()){
            bankList.add(m.getValue());
        }
        return bankList;
    }

    public String getBankNameById(Integer id){
        if(mp.containsKey(id))
            return mp.get(id);
        throw new RuntimeException("Id Not Exist");
    }
}
