package com.example.public_transport_demo.repository;

import com.example.public_transport_demo.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
