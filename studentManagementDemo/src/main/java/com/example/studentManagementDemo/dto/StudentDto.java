package com.example.studentManagementDemo.dto;

import com.example.studentManagementDemo.constant.StringConstant;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentDto {
    private Long id;

    @NotEmpty(message = "Enter the first name.")
    private String firstName;

    @NotEmpty(message = "Enter the last name.")
    private String lastName;

    @Email(message = "The email address is not in the correct format.")
    private String email;

    @Min(value = 18, message = "The age must be at least 18.")
    private Integer age;

    @Pattern(regexp = StringConstant.phoneRegexp)
    private String phone;
}
