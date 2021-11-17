package com.example.book_inventory.controller;

import com.example.book_inventory.entity.Transaction;
import com.example.book_inventory.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction")
    public void createTransaction(@RequestBody Transaction transaction){
        transactionService.createTransaction(transaction);
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransaction(){
        return transactionService.getAllTransaction();
    }
}
