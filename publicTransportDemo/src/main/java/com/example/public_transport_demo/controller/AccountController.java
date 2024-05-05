package com.example.public_transport_demo.controller;

import com.example.public_transport_demo.dto.AccountDto;
import com.example.public_transport_demo.service.AccountService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/accounts/")
public class AccountController {

    private AccountService accountService;

    @PostMapping("createAccount")
    public AccountDto createAccount(@RequestBody @Valid AccountDto accountDto){
        return accountService.create(accountDto);
    }

    @PutMapping("updateAccount")
    public AccountDto updateAccount(@RequestBody @Valid AccountDto accountDto){
        return accountService.update(accountDto);
    }

    @DeleteMapping("deleteAccountById/{accountId}")
    public void deleteAccountById(@PathVariable("accountId") Long accountId){
        accountService.deleteById(accountId);
    }

    @GetMapping("getAccountById/{accountId}")
    public AccountDto getAccountById(@PathVariable("accountId") Long accountId){
        return accountService.getById(accountId);
    }

    @GetMapping("getAllAccounts")
    public List<AccountDto> getAllAccounts() {
        return accountService.getAll();
    }

}
