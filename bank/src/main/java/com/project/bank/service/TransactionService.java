package com.project.bank.service;

import com.project.bank.dao.Account;
import com.project.bank.dao.Transaction;
import com.project.bank.dao.repository.TransactionRepository;
import com.project.bank.dto.NewTransactionDTO;
import com.project.bank.enumeration.TransactionType;
import com.project.bank.exceptions.NoTransactionsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountService accountService;

    public void newTransaction(NewTransactionDTO newTransactionDTO) {
        Account account = accountService.findAccountById(newTransactionDTO.getAccountId());
        Transaction transaction = new Transaction();

        transaction.setAccount(account);
        transaction.setAmount(newTransactionDTO.getAmount());
        transaction.setType(TransactionType.valueOf(newTransactionDTO.getType()));
        transaction.setTransactionDate(LocalDateTime.now());

        transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactions(Long accountId) {
        if (!transactionRepository.findAllTransactions(accountId).isEmpty()) {
            return transactionRepository.findAllTransactions(accountId);
        }
        throw new NoTransactionsException("There are no transactions for account: " + accountId);
    }
}
