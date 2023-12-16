package com.bus.management.repository;

import com.bus.management.entity.BusRouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusRouteRepository extends JpaRepository<BusRouteEntity, Long> {

    Optional<BusRouteEntity> findByRouteName(String routeName);
}
