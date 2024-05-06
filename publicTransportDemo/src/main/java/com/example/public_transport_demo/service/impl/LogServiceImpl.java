package com.example.public_transport_demo.service.impl;

import com.example.public_transport_demo.dto.LogDto;
import com.example.public_transport_demo.entity.Log;
import com.example.public_transport_demo.mapper.LogMapper;
import com.example.public_transport_demo.repository.LogRepository;
import com.example.public_transport_demo.service.LogService;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;
    private final LogMapper logMapper;

    public LogServiceImpl(@Lazy LogRepository logRepository, @Lazy LogMapper logMapper) {
        this.logRepository = logRepository;
        this.logMapper = logMapper;
    }

    @Override
    public LogDto create(LogDto logDto) {
        Log log = logMapper.toEntity(logDto);
        Log createdLog = logRepository.save(log);
        return logMapper.toDto(createdLog);
    }

    @Override
    public List<LogDto> getAll() {
        List<Log> logs = logRepository.findAll();
        return logMapper.toDtoList(logs).stream().sorted(Comparator.comparing(LogDto::getCreateDate).reversed()).collect(Collectors.toList());
    }

}
