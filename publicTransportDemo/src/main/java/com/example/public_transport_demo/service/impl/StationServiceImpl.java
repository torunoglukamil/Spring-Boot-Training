package com.example.public_transport_demo.service.impl;

import com.example.public_transport_demo.dto.StationDto;
import com.example.public_transport_demo.entity.Station;
import com.example.public_transport_demo.exception.ResourceNotFoundException;
import com.example.public_transport_demo.mapper.StationMapper;
import com.example.public_transport_demo.repository.StationRepository;
import com.example.public_transport_demo.service.StationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StationServiceImpl implements StationService {

    private StationRepository stationRepository;
    private StationMapper stationMapper;

    @Override
    public StationDto create(StationDto stationDto) {
        Station station = stationMapper.toEntity(stationDto);
        Station createdStation = stationRepository.save(station);
        return stationMapper.toDto(createdStation);
    }

    @Override
    public StationDto update(StationDto stationDto) {
        Station station = stationRepository.findById(stationDto.getId()).orElseThrow(() -> new ResourceNotFoundException("The station could not found."));
        station.setName(stationDto.getName());
        Station updatedStation = stationRepository.save(station);
        return stationMapper.toDto(updatedStation);
    }

    @Override
    public void deleteById(Long stationId) {
        stationRepository.findById(stationId).orElseThrow(() -> new ResourceNotFoundException("The station could not found."));
        stationRepository.deleteById(stationId);
    }

    @Override
    public StationDto getById(Long stationId) {
        Station station = findById(stationId);
        return stationMapper.toDto(station);
    }

    @Override
    public List<StationDto> getAll() {
        List<Station> stations = stationRepository.findAll();
        return stationMapper.toDtoList(stations);
    }

    @Override
    public Station findById(Long stationId) {
        return stationRepository.findById(stationId).orElseThrow(() -> new ResourceNotFoundException("The station could not found."));
    }

    @Override
    public Long getId(Station station) {
        return station.getId();
    }

}
