package com.example.public_transport_demo.controller;

import com.example.public_transport_demo.dto.AccountDto;
import com.example.public_transport_demo.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts/")
public class AccountController {

    private final AccountService accountService;

    public AccountController(@Lazy AccountService accountService){
        this.accountService = accountService;
    }

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

    @GetMapping("getAllAccountsByFirstName/{firstName}")
    public List<AccountDto> getAllAccountsByFirstName(@PathVariable("firstName") String firstName) {
        return accountService.getAllByFirstName(firstName);
    }

    @GetMapping("getAllAccountsByLastName/{lastName}")
    public List<AccountDto> getAllAccountsByLastName(@PathVariable("lastName") String lastName) {
        return accountService.getAllByLastName(lastName);
    }

    @GetMapping("getAllAccountsByEmail/{email}")
    public List<AccountDto> getAllAccountsByEmail(@PathVariable("email") String email) {
        return accountService.getAllByEmail(email);
    }

    @GetMapping("getAllAccountsByAge/{age}")
    public List<AccountDto> getAllAccountsByAge(@PathVariable("age") Integer age) {
        return accountService.getAllByAge(age);
    }

    @GetMapping("getAllAccountsByPhone/{phone}")
    public List<AccountDto> getAllAccountsByPhone(@PathVariable("phone") String phone) {
        return accountService.getAllByPhone(phone);
    }

}
