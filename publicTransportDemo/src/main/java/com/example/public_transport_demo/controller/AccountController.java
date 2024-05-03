package com.example.public_transport_demo.controller;

import com.example.public_transport_demo.dto.AccountDto;
import com.example.public_transport_demo.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/accounts/")
public class AccountController {

    private AccountService accountService;

    @GetMapping("getAllAccounts")
    public List<AccountDto> getAllAccounts() {
        return accountService.getAllAccounts();
    }

}
