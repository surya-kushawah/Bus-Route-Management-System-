package com.bus.management.dto;

public class BusRouteDTO {
    private String routeName;

    public BusRouteDTO() {
    }

    public BusRouteDTO(String routeName) {
        this.routeName = routeName;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
}
