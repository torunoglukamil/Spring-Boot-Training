package com.example.public_transport_demo.controller;

import com.example.public_transport_demo.dto.AccountDto;
import com.example.public_transport_demo.logger.CustomLogger;
import com.example.public_transport_demo.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts/")
public class AccountController {

    private final AccountService accountService;
    private final CustomLogger customLogger;

    public AccountController(@Lazy AccountService accountService, @Lazy CustomLogger customLogger) {
        this.accountService = accountService;
        this.customLogger = customLogger;
    }

    @PostMapping("createAccount")
    public AccountDto createAccount(@RequestBody @Valid AccountDto accountDto) {
        customLogger.info("AccountController.createAccount");
        return accountService.create(accountDto);
    }

    @PutMapping("updateAccount")
    public AccountDto updateAccount(@RequestBody @Valid AccountDto accountDto) {
        customLogger.info("AccountController.updateAccount");
        return accountService.update(accountDto);
    }

    @DeleteMapping("deleteAccountById/{accountId}")
    public void deleteAccountById(@PathVariable("accountId") Long accountId) {
        customLogger.info("AccountController.deleteAccountById");
        accountService.deleteById(accountId);
    }

    @GetMapping("getAccountById/{accountId}")
    public AccountDto getAccountById(@PathVariable("accountId") Long accountId) {
        customLogger.info("AccountController.getAccountById");
        return accountService.getById(accountId);
    }

    @GetMapping("getAllAccounts")
    public List<AccountDto> getAllAccounts() {
        customLogger.info("AccountController.getAllAccounts");
        return accountService.getAll();
    }

    @GetMapping("getAllAccountsByFirstName/{firstName}")
    public List<AccountDto> getAllAccountsByFirstName(@PathVariable("firstName") String firstName) {
        customLogger.info("AccountController.getAllAccountsByFirstName");
        return accountService.getAllByFirstName(firstName);
    }

    @GetMapping("getAllAccountsByLastName/{lastName}")
    public List<AccountDto> getAllAccountsByLastName(@PathVariable("lastName") String lastName) {
        customLogger.info("AccountController.getAllAccountsByLastName");
        return accountService.getAllByLastName(lastName);
    }

    @GetMapping("getAllAccountsByEmail/{email}")
    public List<AccountDto> getAllAccountsByEmail(@PathVariable("email") String email) {
        customLogger.info("AccountController.getAllAccountsByEmail");
        return accountService.getAllByEmail(email);
    }

    @GetMapping("getAllAccountsByAge/{age}")
    public List<AccountDto> getAllAccountsByAge(@PathVariable("age") Integer age) {
        customLogger.info("AccountController.getAllAccountsByAge");
        return accountService.getAllByAge(age);
    }

    @GetMapping("getAllAccountsByPhone/{phone}")
    public List<AccountDto> getAllAccountsByPhone(@PathVariable("phone") String phone) {
        customLogger.info("AccountController.getAllAccountsByPhone");
        return accountService.getAllByPhone(phone);
    }

}
