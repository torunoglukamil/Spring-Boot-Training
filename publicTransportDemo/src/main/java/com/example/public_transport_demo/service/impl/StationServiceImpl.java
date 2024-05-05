package com.example.public_transport_demo.service.impl;

import com.example.public_transport_demo.dto.StationDto;
import com.example.public_transport_demo.entity.Station;
import com.example.public_transport_demo.exception.ResourceNotFoundException;
import com.example.public_transport_demo.mapper.StationMapper;
import com.example.public_transport_demo.repository.StationRepository;
import com.example.public_transport_demo.service.StationService;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;
    private final StationMapper stationMapper;

    public StationServiceImpl(@Lazy StationRepository stationRepository, @Lazy StationMapper stationMapper){
        this.stationRepository = stationRepository;
        this.stationMapper = stationMapper;
    }

    @Override
    @Transactional
    public StationDto create(StationDto stationDto) {
        Station station = stationMapper.toEntity(stationDto);
        Station createdStation = stationRepository.save(station);
        return stationMapper.toDto(createdStation);
    }

    @Override
    @Transactional
    public StationDto update(StationDto stationDto) {
        Station station = stationRepository.findById(stationDto.getId()).orElseThrow(() -> new ResourceNotFoundException("The station could not found."));
        station.setName(stationDto.getName());
        Station updatedStation = stationRepository.save(station);
        return stationMapper.toDto(updatedStation);
    }

    @Override
    @Transactional
    public void deleteById(Long stationId) {
        stationRepository.findById(stationId).orElseThrow(() -> new ResourceNotFoundException("The station could not found."));
        stationRepository.deleteById(stationId);
    }

    @Override
    @Transactional
    public StationDto getById(Long stationId) {
        Station station = findById(stationId);
        return stationMapper.toDto(station);
    }

    @Override
    @Transactional
    public List<StationDto> getAll() {
        List<Station> stations = stationRepository.findAll();
        return stationMapper.toDtoList(stations);
    }

    @Override
    @Transactional
    public Station findById(Long stationId) {
        return stationRepository.findById(stationId).orElseThrow(() -> new ResourceNotFoundException("The station could not found."));
    }

    @Override
    @Transactional
    public List<Station> findAllByIds(List<Long> stationIds) {
        return stationRepository.findAllById(stationIds);
    }

    @Override
    @Transactional
    public Long getId(Station station) {
        return station.getId();
    }

    @Override
    @Transactional
    public List<Long> getAllIds(List<Station> stations) {
        return stations.stream().map(this::getId).collect(Collectors.toList());
    }

}
