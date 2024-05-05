package com.example.public_transport_demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RouteDto {

    private Long id;

    @NotEmpty(message = "Please enter the route name.")
    private String name;

    @Min(value = 2, message = "Please enter at least 2 stations.")
    private List<Long> stationIds;

    private List<Long> vehicleIds;

}
