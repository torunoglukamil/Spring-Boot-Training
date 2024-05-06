package com.example.public_transport_demo.service;

import com.example.public_transport_demo.dto.LogDto;

import java.util.List;

public interface LogService {

    LogDto create(LogDto logDto);

    List<LogDto> getAll();

}
