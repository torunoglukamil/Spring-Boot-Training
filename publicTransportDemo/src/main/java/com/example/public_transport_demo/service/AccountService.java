package com.example.public_transport_demo.service;

import com.example.public_transport_demo.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto updateAccount(AccountDto accountDto);

    void deleteAccountById(Long accountId);

    AccountDto getAccountById(Long accountId);

    List<AccountDto> getAllAccounts();

}
