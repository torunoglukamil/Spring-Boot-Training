package com.example.public_transport_demo.mapper;

import com.example.public_transport_demo.dto.VehicleDto;
import com.example.public_transport_demo.entity.Vehicle;
import com.example.public_transport_demo.service.RouteService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = { RouteService.class })
public interface VehicleMapper extends BaseMapper<Vehicle, VehicleDto> {

    @Mapping(source = "routeId", target = "route")
    Vehicle toEntity(VehicleDto dto);

    @Mapping(source = "route", target = "routeId")
    VehicleDto toDto(Vehicle entity);
}
