package com.bus.management.service.impl;

import com.bus.management.dto.BusDTO;
import com.bus.management.dto.BusRouteDTO;
import com.bus.management.entity.BusEntity;
import com.bus.management.entity.BusRouteEntity;
import com.bus.management.repository.BusRepository;
import com.bus.management.repository.BusRouteRepository;
import com.bus.management.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusServiceImpl implements BusService {

    private final BusRepository busRepository;
    private final BusRouteRepository busRouteRepository;

    @Autowired
    public BusServiceImpl(BusRepository busRepository, BusRouteRepository busRouteRepository) {
        this.busRepository = busRepository;
        this.busRouteRepository = busRouteRepository;
    }

    @Override
    @Transactional
    public ResponseEntity<String> addBus(BusDTO busDTO) {
        try {
            BusEntity busEntity = new BusEntity();
            busEntity.setRegNumber(busDTO.getRegNumber());
            busEntity.setType(busDTO.getType());
            if (busDTO.getRouteId() != null) {
                BusRouteEntity routeEntity = busRouteRepository.findById(busDTO.getRouteId())
                        .orElseThrow(() -> new EntityNotFoundException("Route not found with ID: " + busDTO.getRouteId()));
                busEntity.setRoute(routeEntity);
            }

            busRepository.save(busEntity);
            return ResponseEntity.ok("Bus added successfully");
        } catch (Exception e) {
            // Log the exception
            System.out.println("Exception occurred while adding Bus " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding Bus");
        }
    }

    @Override
    public ResponseEntity<String> addRoute(BusRouteDTO routeDTO) {
        try {
            BusRouteEntity routeEntity = new BusRouteEntity();
            routeEntity.setRouteName(routeDTO.getRouteName());
            busRouteRepository.save(routeEntity);
            return ResponseEntity.ok("Route added successfully");
        } catch (Exception e) {
            // Log the exception
            System.out.println("Exception occurred while adding route " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding route");
        }

    }

    @Override
    @Transactional
    public void updateBus(Long id, BusDTO busDTO) {
        BusEntity existingBus = busRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bus not found with id: " + id));

        existingBus.setRegNumber(busDTO.getRegNumber());
        existingBus.setType(busDTO.getType());

        busRepository.save(existingBus);
    }

    @Override
    @Transactional
    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BusDTO> getBusesByRoute(Long routeId) {
        List<BusEntity> buses = busRepository.findByRouteId(routeId);
        return buses.stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    private BusDTO mapEntityToDTO(BusEntity busEntity) {
        BusDTO busDTO = new BusDTO();
        busDTO.setId(busEntity.getId());
        busDTO.setRegNumber(busEntity.getRegNumber());
        busDTO.setType(busEntity.getType());
        return busDTO;
    }

    public List<String> getRouteWiseBusDetails(Long routeId) {
        return busRepository.getRouteWiseBusDetails(routeId);
    }
}
