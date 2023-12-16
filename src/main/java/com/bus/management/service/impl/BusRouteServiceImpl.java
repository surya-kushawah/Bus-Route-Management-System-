package com.bus.management.service.impl;

import com.bus.management.entity.BusRouteEntity;
import com.bus.management.repository.BusRouteRepository;
import com.bus.management.service.BusRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BusRouteServiceImpl implements BusRouteService {

    private final BusRouteRepository busRouteRepository;

    @Autowired
    public BusRouteServiceImpl(BusRouteRepository busRouteRepository) {
        this.busRouteRepository = busRouteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BusRouteEntity> getAllRoutes() {
        return busRouteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public BusRouteEntity getRouteById(Long routeId) {
        return busRouteRepository.findById(routeId)
                .orElseThrow(() -> new EntityNotFoundException("Route not found with id: " + routeId));
    }
}

