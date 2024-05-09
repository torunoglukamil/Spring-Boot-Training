package com.example.account_demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Transaction {

    @Id
    @UuidGenerator
    private String id;

    private TransactionType type = TransactionType.INITIAL;

    private BigDecimal amount;

    private LocalDateTime createDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

}

enum TransactionType {
    INITIAL,
    TRANSFER,
}
