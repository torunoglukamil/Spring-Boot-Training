package com.example.public_transport_demo.repository;

import com.example.public_transport_demo.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
}
