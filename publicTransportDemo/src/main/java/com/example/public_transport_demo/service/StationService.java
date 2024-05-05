package com.example.public_transport_demo.service;

import com.example.public_transport_demo.dto.StationDto;
import com.example.public_transport_demo.entity.Station;

import java.util.List;

public interface StationService extends BaseService<Station, StationDto> {

    List<StationDto> getAllByName(String name);

}
