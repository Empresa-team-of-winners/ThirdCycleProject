package com.team.winners.thirdcycleproject.repository;

import com.team.winners.thirdcycleproject.models.Enterprise;
import com.team.winners.thirdcycleproject.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

}
