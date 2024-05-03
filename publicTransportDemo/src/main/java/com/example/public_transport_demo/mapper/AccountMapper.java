package com.example.public_transport_demo.mapper;

import com.example.public_transport_demo.dto.AccountDto;
import com.example.public_transport_demo.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountMapper {

    AccountDto mapToDto(Account account);

    Account mapToEntity(AccountDto accountDto);

}
