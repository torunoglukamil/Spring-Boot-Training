package com.example.public_transport_demo.mapper;

import com.example.public_transport_demo.dto.StationDto;
import com.example.public_transport_demo.entity.Station;
import com.example.public_transport_demo.service.RouteService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = { RouteService.class })
public interface StationMapper extends BaseMapper<Station, StationDto> {

    @Mapping(source = "routeIds", target = "routes")
    Station toEntity(StationDto dto);

    @Mapping(source = "routes", target = "routeIds")
    StationDto toDto(Station entity);

}
