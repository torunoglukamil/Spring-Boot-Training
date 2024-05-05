package com.example.public_transport_demo.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class VehicleDto {

    private Long id;

    @NotEmpty(message = "Please enter the plate.")
    private String plate;

    private Long routeId;

}
