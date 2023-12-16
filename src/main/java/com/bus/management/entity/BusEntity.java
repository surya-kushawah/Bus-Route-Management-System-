package com.bus.management.entity;

import javax.persistence.*;

@Entity
@Table(name = "bus")
public class BusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reg_number", unique = true, nullable = false)
    private String regNumber;

    @Column(name = "type", nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private BusRouteEntity route;

    // Constructors, getters, and setters

    public BusEntity() {
    }

    public BusEntity(String regNumber, String type, BusRouteEntity route) {
        this.regNumber = regNumber;
        this.type = type;
        this.route = route;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BusRouteEntity getRoute() {
        return route;
    }

    public void setRoute(BusRouteEntity route) {
        this.route = route;
    }
}
