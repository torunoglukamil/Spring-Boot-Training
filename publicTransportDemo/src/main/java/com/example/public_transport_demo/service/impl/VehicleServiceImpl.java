package com.example.public_transport_demo.service.impl;

import com.example.public_transport_demo.dto.VehicleDto;
import com.example.public_transport_demo.entity.Vehicle;
import com.example.public_transport_demo.exception.ResourceNotFoundException;
import com.example.public_transport_demo.mapper.VehicleMapper;
import com.example.public_transport_demo.repository.VehicleRepository;
import com.example.public_transport_demo.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository VehicleRepository;
    private VehicleMapper VehicleMapper;

    @Override
    public VehicleDto create(VehicleDto VehicleDto) {
        Vehicle Vehicle = VehicleMapper.toEntity(VehicleDto);
        Vehicle createdVehicle = VehicleRepository.save(Vehicle);
        return VehicleMapper.toDto(createdVehicle);
    }

    @Override
    public VehicleDto update(VehicleDto VehicleDto) {
        Vehicle Vehicle = VehicleRepository.findById(VehicleDto.getId()).orElseThrow(() -> new ResourceNotFoundException("The Vehicle could not found."));
        Vehicle.setName(VehicleDto.getName());
        Vehicle updatedVehicle = VehicleRepository.save(Vehicle);
        return VehicleMapper.toDto(updatedVehicle);
    }

    @Override
    public void deleteById(Long id) {
        VehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The Vehicle could not found."));
        VehicleRepository.deleteById(id);
    }

    @Override
    public VehicleDto getById(Long id) {
        Vehicle Vehicle = findById(id);
        return VehicleMapper.toDto(Vehicle);
    }

    @Override
    public List<VehicleDto> getAll() {
        List<Vehicle> Vehicles = VehicleRepository.findAll();
        return VehicleMapper.toDtoList(Vehicles);
    }

    @Override
    public Vehicle findById(Long id) {
        return VehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The Vehicle could not found."));
    }

    @Override
    public Long getId(Vehicle Vehicle) {
        return Vehicle.getId();
    }

}
