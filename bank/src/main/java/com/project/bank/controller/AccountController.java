package com.project.bank.controller;

import com.project.bank.dao.Account;
import com.project.bank.dto.NewAccountDTO;
import com.project.bank.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    public Account getAccountById(Long id) {
        return accountService.findAccountById(id);
    }

    @PostMapping
    public ResponseEntity<String> createAccount(@Valid @RequestBody NewAccountDTO account) {
        accountService.createAccount(account);
        return ResponseEntity.ok("Account created successfully");

    }
}
