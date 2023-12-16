package com.bus.management.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bus_routes")
public class BusRouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long id;

    @Column(name = "route_name", nullable = false, unique = true)
    private String routeName;

    // Constructors, getters, and setters

    public BusRouteEntity() {
    }

    public BusRouteEntity(String routeName) {
        this.routeName = routeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusRouteEntity that = (BusRouteEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(routeName, that.routeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routeName);
    }
}

