package com.example.public_transport_demo.service;

import com.example.public_transport_demo.dto.VehicleDto;
import com.example.public_transport_demo.entity.Vehicle;

import java.util.List;

public interface VehicleService extends BaseService<Vehicle, VehicleDto> {

    List<VehicleDto> getAllByPlate(String plate);

}
