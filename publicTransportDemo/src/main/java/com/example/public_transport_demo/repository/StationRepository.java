package com.example.public_transport_demo.repository;

import com.example.public_transport_demo.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StationRepository extends JpaRepository<Station, Long> {

    List<Station> findByName(String name);

}
