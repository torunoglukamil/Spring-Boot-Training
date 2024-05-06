package com.example.public_transport_demo.controller;

import com.example.public_transport_demo.dto.LogDto;
import com.example.public_transport_demo.logger.CustomLogger;
import com.example.public_transport_demo.service.LogService;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs/")
public class LogController {

    private final LogService logService;
    private final CustomLogger customLogger;

    public LogController(@Lazy LogService logService, @Lazy CustomLogger customLogger) {
        this.logService = logService;
        this.customLogger = customLogger;
    }

    @GetMapping("getAllLogs")
    public List<LogDto> getAllLogs() {
        customLogger.info("LogController.getAllLogs");
        return logService.getAll();
    }

}
