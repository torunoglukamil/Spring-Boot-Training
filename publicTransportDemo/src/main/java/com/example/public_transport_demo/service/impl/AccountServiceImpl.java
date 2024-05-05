package com.example.public_transport_demo.service.impl;

import com.example.public_transport_demo.dto.AccountDto;
import com.example.public_transport_demo.entity.Account;
import com.example.public_transport_demo.exception.ResourceNotFoundException;
import com.example.public_transport_demo.mapper.AccountMapper;
import com.example.public_transport_demo.repository.AccountRepository;
import com.example.public_transport_demo.service.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(@Lazy AccountRepository accountRepository, @Lazy AccountMapper accountMapper){
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        Account account = accountMapper.toEntity(accountDto);
        Account createdAccount = accountRepository.save(account);
        return accountMapper.toDto(createdAccount);
    }

    @Override
    public AccountDto update(AccountDto accountDto) {
        Account account = accountRepository.findById(accountDto.getId()).orElseThrow(() -> new ResourceNotFoundException("The account could not found."));
        account.setFirstName(accountDto.getFirstName());
        account.setLastName(accountDto.getLastName());
        account.setEmail(accountDto.getEmail());
        account.setAge(accountDto.getAge());
        account.setPhone(accountDto.getPhone());
        Account updatedAccount = accountRepository.save(account);
        return accountMapper.toDto(updatedAccount);
    }

    @Override
    public void deleteById(Long accountId) {
        accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("The account could not found."));
        accountRepository.deleteById(accountId);
    }

    @Override
    public AccountDto getById(Long accountId) {
        Account account = findById(accountId);
        return accountMapper.toDto(account);
    }

    @Override
    public List<AccountDto> getAll() {
        List<Account> accounts = accountRepository.findAll();
        return accountMapper.toDtoList(accounts);
    }

    @Override
    public Account findById(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("The account could not found."));
    }

    @Override
    public List<Account> findAllByIds(List<Long> accountIds) {
        return accountRepository.findAllById(accountIds);
    }

    @Override
    public Long getId(Account account) {
        return account.getId();
    }

    @Override
    public List<Long> getAllIds(List<Account> accounts) {
        return accounts.stream().map(this::getId).collect(Collectors.toList());
    }

}
