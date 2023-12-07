package com.project.bank.dao.repository;

import com.project.bank.dao.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT * FROM transactions t WHERE t.account_id = :accountId", nativeQuery = true)
    List<Transaction> findAllTransactions(@Param("accountId") Long accountId);
}
