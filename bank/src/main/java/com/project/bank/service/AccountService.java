package com.project.bank.service;

import com.project.bank.dao.Account;
import com.project.bank.dao.User;
import com.project.bank.dao.repository.AccountRepository;
import com.project.bank.dto.NewAccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.project.bank.exceptions.AccountNotFoundException;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserService userService;


    public void createAccount(NewAccountDTO newAccountDTO) {
        User user = userService.getUserById(newAccountDTO.getUserId());
        Account account = new Account();
        account.setUser(user);
        account.setBalance(newAccountDTO.getBalance());
        account.setCreationDate(LocalDateTime.now());

        accountRepository.save(account);
    }

    public Account findAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("There is no account for id" + id));
    }

    public List<Account> findAllAccountsForUser(User user) {
        if (!accountRepository.findAllAccountsByUserId(user.getId()).isEmpty()) {
            return accountRepository.findAllAccountsByUserId(user.getId());
        }
        throw new AccountNotFoundException("There is no account for user" + user.getId());
    }

}
