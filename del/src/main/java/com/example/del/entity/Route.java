package com.example.del.entity;

import javax.persistence.*;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long fromCityId;
    private Long toCityId;
    private int distance;

    private Long shipmentId;
    private String routeDetails;

    // Стандартные геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFromCityId() {
        return fromCityId;
    }

    public void setFromCityId(Long fromCityId) {
        this.fromCityId = fromCityId;
    }

    public Long getToCityId() {
        return toCityId;
    }

    public void setToCityId(Long toCityId) {
        this.toCityId = toCityId;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
