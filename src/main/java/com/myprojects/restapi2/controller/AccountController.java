package com.myprojects.restapi2.controller;


import com.myprojects.restapi2.dto.AccountDto;
import com.myprojects.restapi2.mapper.AccountMapper;
import com.myprojects.restapi2.model.Account;
import com.myprojects.restapi2.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;



    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
      return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto =accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);

    }

    //deposit
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String,Double> request){
       AccountDto accountDto= accountService.deposit(id,request.get("amount"));
       return ResponseEntity.ok(accountDto);

    }


    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto>withdraw(@PathVariable  Long id,
                                              @RequestBody Map<String,Double>request
                                              ){
        double amount = request.get("amount");
        AccountDto accountDto= accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }



    @GetMapping
    public ResponseEntity<List<AccountDto>> getAccount(){
       List<AccountDto>accounts =  accountService.getAccount();
            return ResponseEntity.ok(accounts);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){

        accountService.deleteAccount(id);
        return  ResponseEntity.ok("Account Deleted");


    }





}
