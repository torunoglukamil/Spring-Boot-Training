package com.example.public_transport_demo.service.impl;

import com.example.public_transport_demo.dto.AccountDto;
import com.example.public_transport_demo.entity.Account;
import com.example.public_transport_demo.mapper.AccountMapper;
import com.example.public_transport_demo.repository.AccountRepository;
import com.example.public_transport_demo.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(accountMapper::mapToDto).collect(Collectors.toList());
    }

}
