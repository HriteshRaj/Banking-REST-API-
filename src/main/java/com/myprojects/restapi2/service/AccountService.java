package com.myprojects.restapi2.service;


import com.myprojects.restapi2.dto.AccountDto;

import java.util.List;

public interface AccountService {

  AccountDto createAccount(AccountDto accountDto);
  AccountDto getAccountById(Long id);

  AccountDto deposit(Long id,double amount);

  AccountDto withdraw(Long id,double amount);

  List<AccountDto> getAccount();

  void deleteAccount(Long id);

  void transfer(Long fromAccountId,Long toAccountId,double amount);


}
