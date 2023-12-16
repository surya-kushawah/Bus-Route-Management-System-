package com.bus.management.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "bus_schedules")
public class BusScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    private BusEntity bus;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private BusRouteEntity route;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    // Constructors, getters, and setters

    public BusScheduleEntity() {
    }

    public BusScheduleEntity(BusEntity bus, BusRouteEntity route, LocalDateTime startTime, LocalDateTime endTime) {
        this.bus = bus;
        this.route = route;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BusEntity getBus() {
        return bus;
    }

    public void setBus(BusEntity bus) {
        this.bus = bus;
    }

    public BusRouteEntity getRoute() {
        return route;
    }

    public void setRoute(BusRouteEntity route) {
        this.route = route;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusScheduleEntity that = (BusScheduleEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(bus, that.bus) &&
                Objects.equals(route, that.route) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bus, route, startTime, endTime);
    }
}
