package com.bus.management;

import com.bus.management.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan(basePackages = "com.bus.management")
public class BusManagementApplication {


    @Autowired
    private RoleService roleService;

    public static void main(String[] args) {
        SpringApplication.run(BusManagementApplication.class, args);
    }
    @PostConstruct
    public void init() {
        roleService.insertRoles();
    }
}