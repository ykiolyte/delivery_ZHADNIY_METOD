package com.example.del.service;

import com.example.del.entity.City;
import com.example.del.entity.Route;
import com.example.del.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.PriorityQueue;

@Service
public class RouteOptimizationService {

    private final RouteRepository routeRepository;

    public RouteOptimizationService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public List<Route> findOptimalRoute(City fromCity, City toCity) {
        // Приоритетная очередь для хранения маршрутов
        PriorityQueue<Route> queue = new PriorityQueue<>((r1, r2) -> Integer.compare(r1.getDistance(), r2.getDistance()));

        // Добавляем начальные маршруты
        List<Route> initialRoutes = routeRepository.findByFromCityId(fromCity.getCityId());
        queue.addAll(initialRoutes);

        List<Route> optimalRoute = new ArrayList<>();

        while (!queue.isEmpty()) {
            Route currentRoute = queue.poll();

            // Если достигли конечного города, заканчиваем
            if (currentRoute.getToCityId() == toCity.getCityId()) {
                optimalRoute.add(currentRoute);
                break;
            }

            // Добавляем маршрут к оптимальному пути
            optimalRoute.add(currentRoute);

            // Находим следующие маршруты
            List<Route> nextRoutes = routeRepository.findByFromCityId(currentRoute.getToCityId());
            queue.addAll(nextRoutes);
        }

        return optimalRoute;
    }
}
