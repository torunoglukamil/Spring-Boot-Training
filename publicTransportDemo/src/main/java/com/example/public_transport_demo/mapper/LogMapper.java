package com.example.public_transport_demo.mapper;

import com.example.public_transport_demo.dto.LogDto;
import com.example.public_transport_demo.entity.Log;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LogMapper extends BaseMapper<Log, LogDto> {
}
