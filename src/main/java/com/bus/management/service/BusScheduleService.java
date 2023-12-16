package com.bus.management.service;

import com.bus.management.dto.BusScheduleDTO;
import com.bus.management.entity.BusScheduleEntity;

import java.util.List;

public interface BusScheduleService {
    void mapBusToRoute(BusScheduleDTO scheduleDTO);
    List<BusScheduleDTO> getBusSchedulesByBusAndRoute(Long busId, Long routeId);
}
