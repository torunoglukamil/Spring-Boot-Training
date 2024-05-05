package com.example.public_transport_demo.mapper;

import com.example.public_transport_demo.dto.RouteDto;
import com.example.public_transport_demo.entity.Route;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RouteMapper extends BaseMapper<Route, RouteDto> {
}
