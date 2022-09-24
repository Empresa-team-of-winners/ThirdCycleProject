package com.team.winners.thirdcycleproject.controllers;

import com.team.winners.thirdcycleproject.models.Transaction;
import com.team.winners.thirdcycleproject.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/transaction/")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    private ResponseEntity<List<Transaction>> getAllTransaction (){return ResponseEntity.ok(transactionService.findAll());}

    @PostMapping
    private ResponseEntity<Transaction> saveTransaction (@RequestBody Transaction transaction){
        try {
            Transaction transactionSaved = transactionService.save(transaction);
            return ResponseEntity.created(new URI("/transaction/"+transactionSaved.getId())).body(transactionSaved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping (value = "delete/{id}")
    private ResponseEntity<Boolean> deleteTransaction (@PathVariable ("id") Integer id){
        return ResponseEntity.ok(transactionService.deleteById(id));
    }
}
