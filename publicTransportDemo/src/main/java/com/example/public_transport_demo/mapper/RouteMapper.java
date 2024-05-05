package com.example.public_transport_demo.mapper;

import com.example.public_transport_demo.dto.RouteDto;
import com.example.public_transport_demo.entity.Route;
import com.example.public_transport_demo.service.StationService;
import com.example.public_transport_demo.service.VehicleService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = { StationService.class, VehicleService.class })
public interface RouteMapper extends BaseMapper<Route, RouteDto> {

    @Mapping(source = "stationIds", target = "stations")
    @Mapping(source = "vehicleIds", target = "vehicles")
    Route toEntity(RouteDto dto);

    @Mapping(source = "stations", target = "stationIds")
    @Mapping(source = "vehicles", target = "vehicleIds")
    RouteDto toDto(Route entity);

}
