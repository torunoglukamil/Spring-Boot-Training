package com.example.public_transport_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LogDto {

    private Long id;

    private String type;

    private String message;

    private Timestamp createDate;

}
