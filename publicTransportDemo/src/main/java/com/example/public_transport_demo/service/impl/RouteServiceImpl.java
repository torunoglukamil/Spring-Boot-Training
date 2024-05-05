package com.example.public_transport_demo.service.impl;

import com.example.public_transport_demo.dto.RouteDto;
import com.example.public_transport_demo.entity.Route;
import com.example.public_transport_demo.exception.ResourceNotFoundException;
import com.example.public_transport_demo.mapper.RouteMapper;
import com.example.public_transport_demo.repository.RouteRepository;
import com.example.public_transport_demo.service.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RouteServiceImpl implements RouteService {

    private RouteRepository routeRepository;
    private RouteMapper routeMapper;

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
    public Long getId(Route route) {
        return route.getId();
    }

}
