package com.myprojects.restapi2.mapper;

import com.myprojects.restapi2.dto.AccountDto;
import com.myprojects.restapi2.model.Account;

public class AccountMapper {




        public static Account mapToAccount(AccountDto accountDto){


            return new Account(
                    accountDto.getId(),accountDto.getName(),accountDto.getBalance()

            );

        }


        public static AccountDto mapToAccountDto(Account account){
            return new AccountDto(
                    account.getId(),account.getName(),account.getBalance()
            );
        }





}
