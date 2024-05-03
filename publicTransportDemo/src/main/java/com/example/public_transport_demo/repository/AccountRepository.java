package com.example.public_transport_demo.repository;

import com.example.public_transport_demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
