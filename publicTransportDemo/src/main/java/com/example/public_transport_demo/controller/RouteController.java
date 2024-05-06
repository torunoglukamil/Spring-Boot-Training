package com.example.public_transport_demo.controller;

import com.example.public_transport_demo.dto.RouteDto;
import com.example.public_transport_demo.logger.CustomLogger;
import com.example.public_transport_demo.service.RouteService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes/")
public class RouteController {

    private final RouteService routeService;
    private final CustomLogger customLogger;

    public RouteController(@Lazy RouteService routeService, @Lazy CustomLogger customLogger) {
        this.routeService = routeService;
        this.customLogger = customLogger;
    }

    @PostMapping("createRoute")
    public RouteDto createRoute(@RequestBody @Valid RouteDto routeDto) {
        customLogger.info("RouteController.createRoute");
        return routeService.create(routeDto);
    }

    @PutMapping("updateRoute")
    public RouteDto updateRoute(@RequestBody @Valid RouteDto routeDto) {
        customLogger.info("RouteController.updateRoute");
        return routeService.update(routeDto);
    }

    @DeleteMapping("deleteRouteById/{routeId}")
    public void deleteRouteById(@PathVariable("routeId") Long routeId) {
        customLogger.info("RouteController.deleteRouteById");
        routeService.deleteById(routeId);
    }

    @GetMapping("getRouteById/{routeId}")
    public RouteDto getRouteById(@PathVariable("routeId") Long routeId) {
        customLogger.info("RouteController.getRouteById");
        return routeService.getById(routeId);
    }

    @GetMapping("getAllRoutes")
    public List<RouteDto> getAllRoutes() {
        customLogger.info("RouteController.getAllRoutes");
        return routeService.getAll();
    }

    @GetMapping("getAllRoutesByName/{name}")
    public List<RouteDto> getAllRoutesByName(@PathVariable("name") String name) {
        customLogger.info("RouteController.getAllRoutesByName");
        return routeService.getAllByName(name);
    }

}
