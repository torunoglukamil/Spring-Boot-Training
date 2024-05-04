package com.example.public_transport_demo.dto;

import com.example.public_transport_demo.constant.StringConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AccountDto {

    private Long id;

    @NotEmpty(message = "Please enter your first name.")
    private String firstName;

    @NotEmpty(message = "Please enter your last name.")
    private String lastName;

    @Email(message = "Your email address is not in the correct format.")
    private String email;

    @Min(value = 18, message = "Your age must be at least 18.")
    private Integer age;

    @Pattern(regexp = StringConstants.phoneRegexp, message = "Your phone number is not in the correct format.")
    private String phone;

}
