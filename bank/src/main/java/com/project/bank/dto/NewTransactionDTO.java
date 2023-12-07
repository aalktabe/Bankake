package com.project.bank.dto;

import com.project.bank.enumeration.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewTransactionDTO {
    Long accountId;
    String type;
    Double amount;

}
