package com.bus.management.dto;

import java.time.LocalDateTime;

public class BusScheduleDTO {

    private Long busId;
    private Long routeId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // Constructors, getters, and setters

    public BusScheduleDTO() {
    }

    public BusScheduleDTO(Long busId, Long routeId, LocalDateTime startTime, LocalDateTime endTime) {
        this.busId = busId;
        this.routeId = routeId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}

