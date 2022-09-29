package com.team.winners.thirdcycleproject.service;

import com.team.winners.thirdcycleproject.models.Enterprise;
import com.team.winners.thirdcycleproject.models.Transaction;
import com.team.winners.thirdcycleproject.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<Transaction> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.transactionRepository.findAll(pageable);
    }
}
