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

@Transactional
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
    public RouteDto create(RouteDto routeDto) {
        Route route = routeMapper.toEntity(routeDto);
        Route createdRoute = routeRepository.save(route);
        return routeMapper.toDto(createdRoute);
    }

    @Override
    public RouteDto update(RouteDto routeDto) {
        Route route = routeRepository.findById(routeDto.getId()).orElseThrow(() -> new ResourceNotFoundException("The route could not found."));
        route.setName(routeDto.getName());
        List<Station> stations = stationRepository.findAllById(routeDto.getStationIds());
        route.setStations(stations);
        Route updatedRoute = routeRepository.save(route);
        return routeMapper.toDto(updatedRoute);
    }

    @Override
    public void deleteById(Long routeId) {
        routeRepository.findById(routeId).orElseThrow(() -> new ResourceNotFoundException("The route could not found."));
        routeRepository.deleteById(routeId);
    }

    @Override
    public RouteDto getById(Long routeId) {
        Route route = findById(routeId);
        return routeMapper.toDto(route);
    }

    @Override
    public List<RouteDto> getAll() {
        List<Route> routes = routeRepository.findAll();
        return routeMapper.toDtoList(routes);
    }

    @Override
    public Route findById(Long routeId) {
        return routeRepository.findById(routeId).orElseThrow(() -> new ResourceNotFoundException("The route could not found."));
    }

    @Override
    public List<Route> findAllByIds(List<Long> routeIds) {
        return routeRepository.findAllById(routeIds);
    }

    @Override
    public Long getId(Route route) {
        return route.getId();
    }

    @Override
    public List<Long> getAllIds(List<Route> routes) {
        return routes.stream().map(this::getId).collect(Collectors.toList());
    }

    @Override
    public List<RouteDto> getAllByName(String name) {
        List<Route> routes = routeRepository.findByName(name);
        return routeMapper.toDtoList(routes);
    }

}
