package com.example.public_transport_demo.service.impl;

import com.example.public_transport_demo.dto.VehicleDto;
import com.example.public_transport_demo.entity.Route;
import com.example.public_transport_demo.entity.Vehicle;
import com.example.public_transport_demo.exception.ResourceNotFoundException;
import com.example.public_transport_demo.mapper.VehicleMapper;
import com.example.public_transport_demo.repository.RouteRepository;
import com.example.public_transport_demo.repository.VehicleRepository;
import com.example.public_transport_demo.service.VehicleService;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;
    private final RouteRepository routeRepository;

    public VehicleServiceImpl(@Lazy VehicleRepository vehicleRepository, @Lazy VehicleMapper vehicleMapper, @Lazy RouteRepository routeRepository){
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
        this.routeRepository = routeRepository;
    }

    @Override
    @Transactional
    public VehicleDto create(VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleMapper.toEntity(vehicleDto);
        Vehicle createdVehicle = vehicleRepository.save(vehicle);
        return vehicleMapper.toDto(createdVehicle);
    }

    @Override
    @Transactional
    public VehicleDto update(VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleRepository.findById(vehicleDto.getId()).orElseThrow(() -> new ResourceNotFoundException("The vehicle could not found."));
        vehicle.setPlate(vehicleDto.getPlate());
        Route route = routeRepository.findById(vehicleDto.getRouteId()).orElseThrow(() -> new ResourceNotFoundException("The route could not found."));
        vehicle.setRoute(route);
        Vehicle updatedVehicle = vehicleRepository.save(vehicle);
        return vehicleMapper.toDto(updatedVehicle);
    }

    @Override
    @Transactional
    public void deleteById(Long vehicleId) {
        vehicleRepository.findById(vehicleId).orElseThrow(() -> new ResourceNotFoundException("The vehicle could not found."));
        vehicleRepository.deleteById(vehicleId);
    }

    @Override
    @Transactional
    public VehicleDto getById(Long vehicleId) {
        Vehicle vehicle = findById(vehicleId);
        return vehicleMapper.toDto(vehicle);
    }

    @Override
    @Transactional
    public List<VehicleDto> getAll() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicleMapper.toDtoList(vehicles);
    }

    @Override
    @Transactional
    public Vehicle findById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId).orElseThrow(() -> new ResourceNotFoundException("The vehicle could not found."));
    }

    @Override
    @Transactional()
    public List<Vehicle> findAllByIds(List<Long> vehicleIds) {
        return vehicleRepository.findAllById(vehicleIds);
    }

    @Override
    @Transactional
    public Long getId(Vehicle vehicle) {
        return vehicle.getId();
    }

    @Override
    @Transactional
    public List<Long> getAllIds(List<Vehicle> vehicles) {
        return vehicles.stream().map(this::getId).collect(Collectors.toList());
    }

}
