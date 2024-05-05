package com.example.public_transport_demo.service;

import com.example.public_transport_demo.dto.AccountDto;
import com.example.public_transport_demo.entity.Account;

import java.util.List;

public interface AccountService extends BaseService<Account, AccountDto> {

    List<AccountDto> getAllByFirstName(String firstName);

    List<AccountDto> getAllByLastName(String lastName);

    List<AccountDto> getAllByEmail(String email);

    List<AccountDto> getAllByAge(Integer age);

    List<AccountDto> getAllByPhone(String phone);

}
