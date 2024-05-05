package com.example.public_transport_demo.mapper;

import com.example.public_transport_demo.dto.StationDto;
import com.example.public_transport_demo.entity.Station;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StationMapper extends BaseMapper<Station, StationDto> {
}
