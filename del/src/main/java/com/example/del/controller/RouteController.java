package com.example.del.controller;

import com.example.del.entity.City;
import com.example.del.entity.Route;
import com.example.del.service.RouteOptimizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    private final RouteOptimizationService routeOptimizationService;

    @Autowired
    public RouteController(RouteOptimizationService routeOptimizationService) {
        this.routeOptimizationService = routeOptimizationService;
    }

    @GetMapping("/optimal")
    public List<Route> getOptimalRoute(@RequestParam Long fromCityId, @RequestParam Long toCityId) {
        City fromCity = new City(fromCityId);
        City toCity = new City(toCityId);

        return routeOptimizationService.findOptimalRoute(fromCity, toCity);
    }
}
