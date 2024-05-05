package com.example.public_transport_demo;

import com.example.public_transport_demo.controller.AccountController;
import com.example.public_transport_demo.controller.RouteController;
import com.example.public_transport_demo.controller.StationController;
import com.example.public_transport_demo.controller.VehicleController;
import com.example.public_transport_demo.dto.AccountDto;
import com.example.public_transport_demo.dto.RouteDto;
import com.example.public_transport_demo.dto.StationDto;
import com.example.public_transport_demo.dto.VehicleDto;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class Test implements ApplicationListener<ApplicationReadyEvent> {

    private final AccountController accountController;
    private final RouteController routeController;
    private final StationController stationController;
    private final VehicleController vehicleController;

    public Test(@Lazy AccountController accountController, @Lazy RouteController routeController, @Lazy StationController stationController, @Lazy VehicleController vehicleController){
        this.accountController = accountController;
        this.routeController = routeController;
        this.stationController = stationController;
        this.vehicleController = vehicleController;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        List<AccountDto> accountDtos = accountController.getAllAccounts();
        if(accountDtos.isEmpty()){
            AccountDto accountDto = AccountDto.builder().firstName("Ali").lastName("Akyurt").email("ali_akyurt@mail.com").age(20).phone("5012345678").build();
            accountController.createAccount(accountDto);
            accountDto = AccountDto.builder().firstName("Berna").lastName("Büyükağaç").email("berna_buyukagac@mail.com").age(25).phone("5012345679").build();
            accountController.createAccount(accountDto);
            accountDto = AccountDto.builder().firstName("Canan").lastName("Cömert").email("canan_comert@mail.com").age(30).phone("5012345680").build();
            accountController.createAccount(accountDto);
            System.out.println("Test accounts have been created.");
        }/*
        List<StationDto> stationDtos = stationController.getAllStations();
        if(stationDtos.isEmpty()){
            StationDto stationDto = StationDto.builder().name("Alaçatı").routeIds(List.of()).build();
            stationController.createStation(stationDto);
            stationDto = StationDto.builder().name("Beypazarı").routeIds(List.of()).build();
            stationController.createStation(stationDto);
            stationDto = StationDto.builder().name("Canikli").routeIds(List.of()).build();
            stationController.createStation(stationDto);
            System.out.println("Test stations have been created.");
        }
        List<RouteDto> routeDtos = routeController.getAllRoutes();
        if(routeDtos.isEmpty()){
            stationDtos = stationController.getAllStations();
            stationDtos.sort(Comparator.comparing(StationDto::getId).reversed());
            Long stationIdA = stationDtos.stream().findFirst().orElseThrow().getId() + 1L;
            Long stationIdB = stationIdA + 1L;
            Long stationIdC = stationIdB + 1L;
            RouteDto routeDto = RouteDto.builder().name("A-B").stationIds(List.of(stationIdA, stationIdB)).vehicleIds(List.of()).build();
            routeController.createRoute(routeDto);
            routeDto = RouteDto.builder().name("B-C").stationIds(List.of(stationIdB, stationIdC)).vehicleIds(List.of()).build();
            routeController.createRoute(routeDto);
            routeDto = RouteDto.builder().name("C-A").stationIds(List.of(stationIdC, stationIdB, stationIdA)).vehicleIds(List.of()).build();
            routeController.createRoute(routeDto);
            System.out.println("Test routes have been created.");
        }
        List<VehicleDto> vehicleDtos = vehicleController.getAllVehicles();
        if(vehicleDtos.isEmpty()){
            routeDtos = routeController.getAllRoutes();
            routeDtos.sort(Comparator.comparing(RouteDto::getId).reversed());
            Long routeIdA = stationDtos.stream().findFirst().orElseThrow().getId() + 1L;
            Long routeIdB = routeIdA + 1L;
            Long routeIdC = routeIdB + 1L;
            VehicleDto vehicleDto = VehicleDto.builder().plate("06 AA 06").routeId(routeIdA).build();
            vehicleController.createVehicle(vehicleDto);
            vehicleDto = VehicleDto.builder().plate("06 BB 06").routeId(routeIdB).build();
            vehicleController.createVehicle(vehicleDto);
            vehicleDto = VehicleDto.builder().plate("06 CC 06").routeId(routeIdC).build();
            vehicleController.createVehicle(vehicleDto);
            System.out.println("Test vehicles have been created.");
        }*/
    }

}
