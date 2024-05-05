package com.example.public_transport_demo;

import com.example.public_transport_demo.controller.AccountController;
import com.example.public_transport_demo.dto.AccountDto;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class Test implements ApplicationListener<ApplicationReadyEvent> {

    private AccountController accountController;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        List<AccountDto> accountDtos = accountController.getAllAccounts();
        if(accountDtos.isEmpty()){
            AccountDto accountDto = AccountDto.builder().firstName("Ali").lastName("Akyurt").email("ali_akyurt@mail.com").age(20).phone("5012345678").build();
            accountController.createAccount(accountDto);
            accountDto = AccountDto.builder().firstName("Berna").lastName("Büyükağaç").email("berna_buyukagac@mail.com").age(25).phone("5012345679").build();
            accountController.createAccount(accountDto);
            accountDto = AccountDto.builder().firstName("Canan").lastName("Cömert").email("canan_comert@mail.com").age(30).phone("5012345680").build();
            accountController.createAccount(accountDto);
            System.out.println("Test accounts have been created.");
        }
    }

}
