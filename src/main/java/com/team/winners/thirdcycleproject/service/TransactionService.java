package com.team.winners.thirdcycleproject.service;

import com.team.winners.thirdcycleproject.models.Transaction;
import com.team.winners.thirdcycleproject.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public <S extends Transaction> S save(S entity) {
        return transactionRepository.save(entity);
    }

    public void update(Transaction transactionRequest, Long id){
        Optional<Transaction> transactionOp = this.transactionRepository.findById(id);
        Transaction transaction = transactionOp.get();

        transaction.setAmount(transactionRequest.getAmount());
        transaction.setConcept(transactionRequest.getConcept());

    }

    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

}
