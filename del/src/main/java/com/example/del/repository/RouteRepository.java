package com.example.del.repository;

import com.example.del.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findByFromCityId(Long fromCityId);
}
