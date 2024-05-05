package com.example.public_transport_demo.controller;

import com.example.public_transport_demo.dto.StationDto;
import com.example.public_transport_demo.service.StationService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stations/")
public class StationController {

    private final StationService stationService;

    public StationController(@Lazy StationService stationService){
        this.stationService = stationService;
    }

    @PostMapping("createStation")
    public StationDto createStation(@RequestBody @Valid StationDto stationDto){
        return stationService.create(stationDto);
    }

    @PutMapping("updateStation")
    public StationDto updateStation(@RequestBody @Valid StationDto stationDto){
        return stationService.update(stationDto);
    }

    @DeleteMapping("deleteStationById/{stationId}")
    public void deleteStationById(@PathVariable("stationId") Long stationId){
        stationService.deleteById(stationId);
    }

    @GetMapping("getStationById/{stationId}")
    public StationDto getStationById(@PathVariable("stationId") Long stationId){
        return stationService.getById(stationId);
    }

    @GetMapping("getAllStations")
    public List<StationDto> getAllStations() {
        return stationService.getAll();
    }

}
