package com.example.public_transport_demo.controller;

import com.example.public_transport_demo.dto.VehicleDto;
import com.example.public_transport_demo.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles/")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(@Lazy VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @PostMapping("createVehicle")
    public VehicleDto createVehicle(@RequestBody @Valid VehicleDto vehicleDto){
        return vehicleService.create(vehicleDto);
    }

    @PutMapping("updateVehicle")
    public VehicleDto updateVehicle(@RequestBody @Valid VehicleDto vehicleDto){
        return vehicleService.update(vehicleDto);
    }

    @DeleteMapping("deleteVehicleById/{vehicleId}")
    public void deleteVehicleById(@PathVariable("vehicleId") Long vehicleId){
        vehicleService.deleteById(vehicleId);
    }

    @GetMapping("getVehicleById/{vehicleId}")
    public VehicleDto getVehicleById(@PathVariable("vehicleId") Long vehicleId){
        return vehicleService.getById(vehicleId);
    }

    @GetMapping("getAllVehicles")
    public List<VehicleDto> getAllVehicles() {
        return vehicleService.getAll();
    }

    @GetMapping("getAllVehiclesByPlate/{plate}")
    public List<VehicleDto> getAllVehiclesByPlate(@PathVariable("plate") String plate) {
        return vehicleService.getAllByPlate(plate);
    }

}
