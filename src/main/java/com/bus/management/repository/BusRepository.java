package com.bus.management.repository;

import com.bus.management.entity.BusEntity;
import com.bus.management.entity.BusRouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BusRepository extends JpaRepository<BusEntity, Long> {
    List<BusEntity> findByRouteId(Long routeId);

    @Procedure(name = "GetRouteWiseBusDetails")
    List<String> getRouteWiseBusDetails(@Param("routeId") Long routeId);
}

