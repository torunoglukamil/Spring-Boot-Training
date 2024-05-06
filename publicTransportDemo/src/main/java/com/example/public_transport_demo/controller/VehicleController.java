package com.example.public_transport_demo.controller;

import com.example.public_transport_demo.dto.VehicleDto;
import com.example.public_transport_demo.logger.CustomLogger;
import com.example.public_transport_demo.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles/")
public class VehicleController {

    private final VehicleService vehicleService;
    private final CustomLogger customLogger;

    public VehicleController(@Lazy VehicleService vehicleService, @Lazy CustomLogger customLogger) {
        this.vehicleService = vehicleService;
        this.customLogger = customLogger;
    }

    @PostMapping("createVehicle")
    public VehicleDto createVehicle(@RequestBody @Valid VehicleDto vehicleDto) {
        customLogger.info("VehicleController.createVehicle");
        return vehicleService.create(vehicleDto);
    }

    @PutMapping("updateVehicle")
    public VehicleDto updateVehicle(@RequestBody @Valid VehicleDto vehicleDto) {
        customLogger.info("VehicleController.updateVehicle");
        return vehicleService.update(vehicleDto);
    }

    @DeleteMapping("deleteVehicleById/{vehicleId}")
    public void deleteVehicleById(@PathVariable("vehicleId") Long vehicleId) {
        customLogger.info("VehicleController.deleteVehicleById");
        vehicleService.deleteById(vehicleId);
    }

    @GetMapping("getVehicleById/{vehicleId}")
    public VehicleDto getVehicleById(@PathVariable("vehicleId") Long vehicleId) {
        customLogger.info("VehicleController.getVehicleById");
        return vehicleService.getById(vehicleId);
    }

    @GetMapping("getAllVehicles")
    public List<VehicleDto> getAllVehicles() {
        customLogger.info("VehicleController.getAllVehicles");
        return vehicleService.getAll();
    }

    @GetMapping("getAllVehiclesByPlate/{plate}")
    public List<VehicleDto> getAllVehiclesByPlate(@PathVariable("plate") String plate) {
        customLogger.info("VehicleController.getAllVehiclesByPlate");
        return vehicleService.getAllByPlate(plate);
    }

}
