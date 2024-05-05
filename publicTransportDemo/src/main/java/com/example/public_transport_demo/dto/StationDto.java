package com.example.public_transport_demo.dto;

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
public class StationDto {

    private Long id;

    @NotEmpty(message = "Please enter the station name.")
    private String name;

    private List<Long> routeIds;

}
