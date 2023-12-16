package com.bus.management.service;

import com.bus.management.entity.BusRouteEntity;

import java.util.List;

public interface BusRouteService {
    List<BusRouteEntity> getAllRoutes();
    BusRouteEntity getRouteById(Long routeId);
}

