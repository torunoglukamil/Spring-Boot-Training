package com.example.studentManagementDemo.repository;

import com.example.studentManagementDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}
