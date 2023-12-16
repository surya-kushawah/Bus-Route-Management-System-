package com.bus.management.config;

public class BusProcedure {

    public static String getRouteWiseBusDetails(long routeId) {
        // Your stored procedure logic here
        return "SELECT b.reg_number FROM bus b JOIN bus_route br ON b.route_id = br.id WHERE br.id = " + routeId;
    }
}
