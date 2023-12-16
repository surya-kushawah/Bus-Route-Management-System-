package com.bus.management.dto;

public class BusDTO {

    private Long id;
    private String regNumber;
    private String type;
    private Long routeId;

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
// Constructors, getters, and setters

    public BusDTO() {
        // Default constructor
    }

    public BusDTO(Long id, String regNumber, String type) {
        this.id = id;
        this.regNumber = regNumber;
        this.type = type;
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

    // Other utility methods or validations can be added if needed

    @Override
    public String toString() {
        return "BusDTO{" +
                "id=" + id +
                ", regNumber='" + regNumber + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
