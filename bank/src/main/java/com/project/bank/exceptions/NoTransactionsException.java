package com.project.bank.exceptions;

public class NoTransactionsException extends RuntimeException{

    public NoTransactionsException(String message) {
        super(message);
    }
}
