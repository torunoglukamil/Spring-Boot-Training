package com.example.public_transport_demo.controller;

import com.example.public_transport_demo.dto.StationDto;
import com.example.public_transport_demo.logger.CustomLogger;
import com.example.public_transport_demo.service.StationService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stations/")
public class StationController {

    private final StationService stationService;
    private final CustomLogger customLogger;

    public StationController(@Lazy StationService stationService, @Lazy CustomLogger customLogger) {
        this.stationService = stationService;
        this.customLogger = customLogger;
    }

    @PostMapping("createStation")
    public StationDto createStation(@RequestBody @Valid StationDto stationDto) {
        customLogger.info("StationController.createStation");
        return stationService.create(stationDto);
    }

    @PutMapping("updateStation")
    public StationDto updateStation(@RequestBody @Valid StationDto stationDto) {
        customLogger.info("StationController.updateStation");
        return stationService.update(stationDto);
    }

    @DeleteMapping("deleteStationById/{stationId}")
    public void deleteStationById(@PathVariable("stationId") Long stationId) {
        customLogger.info("StationController.deleteStationById");
        stationService.deleteById(stationId);
    }

    @GetMapping("getStationById/{stationId}")
    public StationDto getStationById(@PathVariable("stationId") Long stationId) {
        customLogger.info("StationController.getStationById");
        return stationService.getById(stationId);
    }

    @GetMapping("getAllStations")
    public List<StationDto> getAllStations() {
        customLogger.info("StationController.getAllStations");
        return stationService.getAll();
    }

    @GetMapping("getAllStationsByName/{name}")
    public List<StationDto> getAllStationsByName(@PathVariable("name") String name) {
        customLogger.info("StationController.getAllStationsByName");
        return stationService.getAllByName(name);
    }

}
