package com.example.studentManagementDemo.service.impl;

import com.example.studentManagementDemo.dto.StudentDto;
import com.example.studentManagementDemo.entity.Student;
import com.example.studentManagementDemo.exception.ResourceNotFoundException;
import com.example.studentManagementDemo.mapper.StudentMapper;
import com.example.studentManagementDemo.repository.StudentRepository;
import com.example.studentManagementDemo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = studentMapper.mapToEntity(studentDto);
        Student createdStudent = studentRepository.save(student);
        return studentMapper.mapToDto(createdStudent);
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) {
        Student student = studentRepository.findById(studentDto.getId()).orElseThrow(() -> new ResourceNotFoundException("The student could not found."));
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        Student updatedStudent = studentRepository.save(student);
        return studentMapper.mapToDto(updatedStudent);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("The student could not found."));
        studentRepository.deleteById(studentId);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("The student could not found."));
        return studentMapper.mapToDto(student);
    }

    @Override
    public List<StudentDto> getStudentByName(String studentName) {
        List<Student> students = studentRepository.findByFirstName(studentName);
        return students.stream().map(studentMapper::mapToDto).sorted(Comparator.comparing(StudentDto::getId).reversed()).collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getStudentByAge(Integer age) {
        List<Student> students = studentRepository.findByAge(age);
        return students.stream().map(studentMapper::mapToDto).sorted(Comparator.comparing(StudentDto::getId).reversed()).collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(studentMapper::mapToDto).sorted(Comparator.comparing(StudentDto::getId).reversed()).collect(Collectors.toList());
    }
}
