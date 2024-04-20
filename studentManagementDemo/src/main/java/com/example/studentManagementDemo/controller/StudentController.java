package com.example.studentManagementDemo.controller;

import com.example.studentManagementDemo.dto.StudentDto;
import com.example.studentManagementDemo.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students/")
public class StudentController {
    private StudentService studentService;

    @PostMapping("createStudent")
    public StudentDto createStudent(@RequestBody @Valid StudentDto studentDto){
        return studentService.createStudent(studentDto);
    }

    @PutMapping("updateStudent")
    public StudentDto updateStudent(@RequestBody @Valid StudentDto studentDto){
        return studentService.updateStudent(studentDto);
    }

    @DeleteMapping("deleteStudentById/{studentId}")
    public void deleteStudentById(@PathVariable("studentId") Long studentId){
        studentService.deleteStudentById(studentId);
    }

    @GetMapping("getStudentById/{studentId}")
    public StudentDto getStudentById(@PathVariable("studentId") Long studentId){
        return studentService.getStudentById(studentId);
    }

    @GetMapping("getStudentByName/{name}")
    public List<StudentDto> getStudentByName(@PathVariable("name") String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping("getStudentByAge/{yas}")
    public List<StudentDto> getStudentByAge(@PathVariable("yas") Integer age){
        return studentService.getStudentByAge(age);
    }

    @GetMapping("getAllStudents")
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }
}
