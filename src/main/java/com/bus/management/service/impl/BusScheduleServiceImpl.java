package com.bus.management.service.impl;

import com.bus.management.dto.BusScheduleDTO;
import com.bus.management.entity.BusEntity;
import com.bus.management.entity.BusRouteEntity;
import com.bus.management.entity.BusScheduleEntity;
import com.bus.management.repository.BusRepository;
import com.bus.management.repository.BusRouteRepository;
import com.bus.management.repository.BusScheduleRepository;
import com.bus.management.service.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusScheduleServiceImpl implements BusScheduleService {

    private final BusScheduleRepository busScheduleRepository;
    private final BusRepository busRepository;
    private final BusRouteRepository busRouteRepository;

    @Autowired
    public BusScheduleServiceImpl(BusScheduleRepository busScheduleRepository,
                                  BusRepository busRepository,
                                  BusRouteRepository busRouteRepository) {
        this.busScheduleRepository = busScheduleRepository;
        this.busRepository = busRepository;
        this.busRouteRepository = busRouteRepository;
    }

    @Override
    @Transactional
    public void mapBusToRoute(BusScheduleDTO scheduleDTO) {
        BusEntity busEntity = busRepository.findById(scheduleDTO.getBusId())
                .orElseThrow(() -> new EntityNotFoundException("Bus not found with id: " + scheduleDTO.getBusId()));

        BusRouteEntity routeEntity = busRouteRepository.findById(scheduleDTO.getRouteId())
                .orElseThrow(() -> new EntityNotFoundException("Route not found with id: " + scheduleDTO.getRouteId()));

        // Validate for overlapping schedules, start time, and end time constraints
        // ...

        BusScheduleEntity scheduleEntity = new BusScheduleEntity();
        scheduleEntity.setBus(busEntity);
        scheduleEntity.setRoute(routeEntity);
        scheduleEntity.setStartTime(scheduleDTO.getStartTime());
        scheduleEntity.setEndTime(scheduleDTO.getEndTime());

        busScheduleRepository.save(scheduleEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BusScheduleDTO> getBusSchedulesByBusAndRoute(Long busId, Long routeId) {
        List<BusScheduleEntity> schedules = busScheduleRepository.findByBusIdAndRouteId(busId, routeId);
        return schedules.stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    private BusScheduleDTO mapEntityToDTO(BusScheduleEntity scheduleEntity) {
        BusScheduleDTO scheduleDTO = new BusScheduleDTO();
        scheduleDTO.setBusId(scheduleEntity.getBus().getId());
        scheduleDTO.setRouteId(scheduleEntity.getRoute().getId());
        scheduleDTO.setStartTime(scheduleEntity.getStartTime());
        scheduleDTO.setEndTime(scheduleEntity.getEndTime());
        return scheduleDTO;
    }
}



