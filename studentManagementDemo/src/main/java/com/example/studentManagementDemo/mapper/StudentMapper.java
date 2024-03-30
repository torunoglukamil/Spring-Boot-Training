package com.example.studentManagementDemo.mapper;

import com.example.studentManagementDemo.dto.StudentDto;
import com.example.studentManagementDemo.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {
    StudentDto mapToDto(Student student);

    Student mapToEntity(StudentDto studentDto);
}
