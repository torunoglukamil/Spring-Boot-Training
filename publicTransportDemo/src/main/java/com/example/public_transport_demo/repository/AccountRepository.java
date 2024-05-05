package com.example.public_transport_demo.repository;

import com.example.public_transport_demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByFirstName(String firstName);

    List<Account> findByLastName(String lastName);

    List<Account> findByEmail(String email);

    List<Account> findByAge(Integer age);

    List<Account> findByPhone(String phone);

}
