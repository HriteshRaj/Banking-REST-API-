package com.myprojects.restapi2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class TransferMoneyDto {
    private Long fromAccountId;
    private Long toAccountId;
    private double balance;
}
