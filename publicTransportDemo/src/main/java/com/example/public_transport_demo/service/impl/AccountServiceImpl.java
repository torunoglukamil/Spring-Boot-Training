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

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

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
    public void deleteById(Long id) {
        accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The account could not found."));
        accountRepository.deleteById(id);
    }

    @Override
    public AccountDto getById(Long id) {
        Account account = findById(id);
        return accountMapper.toDto(account);
    }

    @Override
    public List<AccountDto> getAll() {
        List<Account> accounts = accountRepository.findAll();
        return accountMapper.toDtoList(accounts);
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The account could not found."));
    }

    @Override
    public Long getId(Account account) {
        return account.getId();
    }

}
