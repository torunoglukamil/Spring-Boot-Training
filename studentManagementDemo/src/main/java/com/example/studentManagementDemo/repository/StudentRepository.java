package com.example.studentManagementDemo.repository;

import com.example.studentManagementDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
//    @Query(value = "select s from students s where s.firstName")
    List<Student> findByFirstName(String name);

    List<Student> findByAge(Integer age);
}
