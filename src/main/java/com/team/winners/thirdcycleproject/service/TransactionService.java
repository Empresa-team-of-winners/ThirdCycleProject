package com.team.winners.thirdcycleproject.service;

import com.team.winners.thirdcycleproject.models.Transaction;
import com.team.winners.thirdcycleproject.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public <S extends Transaction> S save(S entity) {
        return transactionRepository.save(entity);
    }

    public void update(Transaction transactionRequest, Integer id){
        Optional<Transaction> transactionOp = this.transactionRepository.findById(id);
        Transaction transaction = transactionOp.get();

        transaction.setAmount(transactionRequest.getAmount());
        transaction.setConcept(transactionRequest.getConcept());

    }

    public Optional<Transaction> findById(Integer id) {
        return transactionRepository.findById(id);
    }

    public Boolean deleteById(Integer id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
