package com.example.public_transport_demo.controller;

import com.example.public_transport_demo.dto.RouteDto;
import com.example.public_transport_demo.service.RouteService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes/")
public class RouteController {

    private final RouteService routeService;

    public RouteController(@Lazy RouteService routeService){
        this.routeService = routeService;
    }

    @PostMapping("createRoute")
    public RouteDto createRoute(@RequestBody @Valid RouteDto routeDto){
        return routeService.create(routeDto);
    }

    @PutMapping("updateRoute")
    public RouteDto updateRoute(@RequestBody @Valid RouteDto routeDto){
        return routeService.update(routeDto);
    }

    @DeleteMapping("deleteRouteById/{routeId}")
    public void deleteRouteById(@PathVariable("routeId") Long routeId){
        routeService.deleteById(routeId);
    }

    @GetMapping("getRouteById/{routeId}")
    public RouteDto getRouteById(@PathVariable("routeId") Long routeId){
        return routeService.getById(routeId);
    }

    @GetMapping("getAllRoutes")
    public List<RouteDto> getAllRoutes() {
        return routeService.getAll();
    }

}
