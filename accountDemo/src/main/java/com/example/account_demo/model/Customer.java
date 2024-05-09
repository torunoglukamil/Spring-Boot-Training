package com.example.account_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {

    @Id
    @UuidGenerator
    private String id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Account> accounts;

}
