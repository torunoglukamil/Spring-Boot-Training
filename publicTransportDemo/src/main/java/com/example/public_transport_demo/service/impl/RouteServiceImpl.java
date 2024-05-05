package com.example.public_transport_demo.service.impl;

import com.example.public_transport_demo.dto.RouteDto;
import com.example.public_transport_demo.entity.Route;
import com.example.public_transport_demo.entity.Station;
import com.example.public_transport_demo.exception.ResourceNotFoundException;
import com.example.public_transport_demo.mapper.RouteMapper;
import com.example.public_transport_demo.repository.RouteRepository;
import com.example.public_transport_demo.repository.StationRepository;
import com.example.public_transport_demo.service.RouteService;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final RouteMapper routeMapper;
    private final StationRepository stationRepository;

    public RouteServiceImpl(@Lazy RouteRepository routeRepository, @Lazy RouteMapper routeMapper, @Lazy StationRepository stationRepository){
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
        this.stationRepository = stationRepository;
    }

    @Override
    @Transactional
    public RouteDto create(RouteDto routeDto) {
        Route route = routeMapper.toEntity(routeDto);
        Route createdRoute = routeRepository.save(route);
        return routeMapper.toDto(createdRoute);
    }

    @Override
    @Transactional
    public RouteDto update(RouteDto routeDto) {
        Route route = routeRepository.findById(routeDto.getId()).orElseThrow(() -> new ResourceNotFoundException("The route could not found."));
        route.setName(routeDto.getName());
        List<Station> stations = stationRepository.findAllById(routeDto.getStationIds());
        route.setStations(stations);
        Route updatedRoute = routeRepository.save(route);
        return routeMapper.toDto(updatedRoute);
    }

    @Override
    @Transactional
    public void deleteById(Long routeId) {
        routeRepository.findById(routeId).orElseThrow(() -> new ResourceNotFoundException("The route could not found."));
        routeRepository.deleteById(routeId);
    }

    @Override
    @Transactional
    public RouteDto getById(Long routeId) {
        Route route = findById(routeId);
        return routeMapper.toDto(route);
    }

    @Override
    @Transactional
    public List<RouteDto> getAll() {
        List<Route> routes = routeRepository.findAll();
        return routeMapper.toDtoList(routes);
    }

    @Override
    @Transactional
    public Route findById(Long routeId) {
        return routeRepository.findById(routeId).orElseThrow(() -> new ResourceNotFoundException("The route could not found."));
    }

    @Override
    @Transactional
    public List<Route> findAllByIds(List<Long> routeIds) {
        return routeRepository.findAllById(routeIds);
    }

    @Override
    @Transactional
    public Long getId(Route route) {
        return route.getId();
    }

    @Override
    @Transactional
    public List<Long> getAllIds(List<Route> routes) {
        return routes.stream().map(this::getId).collect(Collectors.toList());
    }

}
