package com.example.studentManagementDemo.service;

import com.example.studentManagementDemo.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);

    StudentDto updateStudent(StudentDto studentDto);

    void deleteStudentById(Long studentId);

    StudentDto getStudentById(Long studentId);

    List<StudentDto> getAllStudents();
}
