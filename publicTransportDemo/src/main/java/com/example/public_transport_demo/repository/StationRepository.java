package com.example.public_transport_demo.repository;

import com.example.public_transport_demo.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
}