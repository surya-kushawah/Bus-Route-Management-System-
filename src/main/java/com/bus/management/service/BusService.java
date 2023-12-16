package com.bus.management.service;


import com.bus.management.dto.BusDTO;
import com.bus.management.dto.BusRouteDTO;
import com.bus.management.entity.BusEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BusService {
    ResponseEntity<String> addBus(BusDTO busDTO);

    ResponseEntity<String> addRoute(BusRouteDTO routeDTO);

    void updateBus(Long id, BusDTO busDTO);

    void deleteBus(Long id);

    List<BusDTO> getBusesByRoute(Long routeId);

    List<String> getRouteWiseBusDetails(Long routeId);

}