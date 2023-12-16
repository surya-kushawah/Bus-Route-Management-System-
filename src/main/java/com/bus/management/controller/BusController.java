package com.bus.management.controller;

import com.bus.management.dto.BusDTO;
import com.bus.management.dto.BusRouteDTO;
import com.bus.management.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus")
public class BusController {

    private final BusService busService;

    @Autowired
    public BusController(BusService busService) {
        this.busService = busService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBus(@RequestBody BusDTO busDTO) {
        ResponseEntity<String> response = busService.addBus(busDTO);
        System.out.println(response);
        return  ResponseEntity.ok("Bus added successfully");
    }

    @PostMapping("/addRoute")
    public ResponseEntity<String> addRoute(@RequestBody BusRouteDTO routeDTO) {
        ResponseEntity<String> response = busService.addRoute(routeDTO);
        System.out.println(response);
        return ResponseEntity.ok("Route added successfully");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateBus(@PathVariable Long id, @RequestBody BusDTO busDTO) {
        busService.updateBus(id, busDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBus(@PathVariable Long id) {
        busService.deleteBus(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getByRoute/{routeId}")
    public ResponseEntity<List<BusDTO>> getBusesByRoute(@PathVariable Long routeId) {
        List<BusDTO> buses = busService.getBusesByRoute(routeId);
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }

    @GetMapping("/route-wise-details/{routeId}")
    public ResponseEntity<List<String>> getRouteWiseBusDetails(@PathVariable Long routeId) {
        List<String> details = busService.getRouteWiseBusDetails(routeId);
        return new ResponseEntity<>(details, HttpStatus.OK);
    }
}
