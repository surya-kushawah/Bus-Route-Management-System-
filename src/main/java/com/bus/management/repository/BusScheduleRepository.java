package com.bus.management.repository;

import com.bus.management.entity.BusScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BusScheduleRepository extends JpaRepository<BusScheduleEntity, Long> {
    List<BusScheduleEntity> findByBusIdAndRouteId(Long busId, Long routeId);
}

