package com.example.public_transport_demo.logger;

import com.example.public_transport_demo.dto.LogDto;
import com.example.public_transport_demo.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class CustomLogger {

    private final Logger logger = LoggerFactory.getLogger(CustomLogger.class);
    private final LogService logService;

    public CustomLogger(@Lazy LogService logService) {
        this.logService = logService;
    }

    public void debug(String message) {
        logger.debug(message);
        LogDto logDto = getLogDto("debug", message);
        logService.create(logDto);
    }

    public void error(String message) {
        logger.error(message);
        LogDto logDto = getLogDto("error", message);
        logService.create(logDto);
    }

    public void info(String message) {
        logger.info(message);
        LogDto logDto = getLogDto("info", message);
        logService.create(logDto);
    }

    public void warn(String message) {
        logger.warn(message);
        LogDto logDto = getLogDto("warn", message);
        logService.create(logDto);
    }

    private LogDto getLogDto(String type, String message) {
        return LogDto.builder().type(type).message(message).createDate(Timestamp.valueOf(LocalDateTime.now())).build();
    }

}
