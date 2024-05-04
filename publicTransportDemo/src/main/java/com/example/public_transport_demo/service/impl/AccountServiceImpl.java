package com.example.public_transport_demo.service.impl;

import com.example.public_transport_demo.dto.AccountDto;
import com.example.public_transport_demo.entity.Account;
import com.example.public_transport_demo.exception.ResourceNotFoundException;
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
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = accountMapper.mapToEntity(accountDto);
        Account createdAccount = accountRepository.save(account);
        return accountMapper.mapToDto(createdAccount);
    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto) {
        Account account = accountRepository.findById(accountDto.getId()).orElseThrow(() -> new ResourceNotFoundException("The account could not found."));
        account.setFirstName(accountDto.getFirstName());
        account.setLastName(accountDto.getLastName());
        account.setEmail(accountDto.getEmail());
        account.setAge(accountDto.getAge());
        account.setPhone(accountDto.getPhone());
        Account updatedAccount = accountRepository.save(account);
        return accountMapper.mapToDto(updatedAccount);
    }

    @Override
    public void deleteAccountById(Long accountId) {
        accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("The account could not found."));
        accountRepository.deleteById(accountId);
    }

    @Override
    public AccountDto getAccountById(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("The account could not found."));
        return accountMapper.mapToDto(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(accountMapper::mapToDto).collect(Collectors.toList());
    }

}
