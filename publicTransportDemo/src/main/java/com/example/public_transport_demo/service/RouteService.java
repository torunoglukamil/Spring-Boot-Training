package com.example.public_transport_demo.service;

import com.example.public_transport_demo.dto.RouteDto;
import com.example.public_transport_demo.entity.Route;

import java.util.List;

public interface RouteService extends BaseService<Route, RouteDto> {

    List<RouteDto> getAllByName(String name);

}
