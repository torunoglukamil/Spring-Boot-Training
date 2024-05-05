package com.example.public_transport_demo.repository;

import com.example.public_transport_demo.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByPlate(String plate);

}
