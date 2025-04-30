package com.myprojects.restapi2.service.impl;

import com.myprojects.restapi2.dto.AccountDto;
import com.myprojects.restapi2.mapper.AccountMapper;
import com.myprojects.restapi2.model.Account;
import com.myprojects.restapi2.repository.AccountRepository;
import com.myprojects.restapi2.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class AccountServiceImpl  implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
       Account savedAccount = accountRepository.save(account);
       return AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account =accountRepository.findById(id).orElseThrow(

                ()-> new RuntimeException("Account Not Found")
        );
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account =accountRepository.findById(id).orElseThrow(

                ()-> new RuntimeException("Account Not Found")
        );
        double total=account.getBalance()+amount;
        account.setBalance(total);
        Account savedAccount =accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {


        Account account =accountRepository.findById(id).orElseThrow(

                ()->new RuntimeException("Account Not Found")
        );

        if(account.getBalance()<amount){
            throw new RuntimeException("Insufficient Funds");
        }
        double total = account.getBalance()-amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAccount() {
        List<Account>accounts= accountRepository.findAll();
        return accounts.stream().map(
                        AccountMapper::mapToAccountDto).toList();

    }

    @Override
    public void deleteAccount(Long id) {

       Account account= accountRepository.findById(id).orElseThrow(
               ()->new RuntimeException("Account Not Found")
       );

       accountRepository.deleteById(account.getId());






    }
}
