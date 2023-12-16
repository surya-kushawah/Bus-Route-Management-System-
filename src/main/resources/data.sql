CREATE TABLE USER_ROLE (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);
-- Insert roles for users
INSERT INTO user_role (name) VALUES ('ROLE_ADMIN');
INSERT INTO user_role (name) VALUES ('ROLE_USER');

-- Create users
CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);
-- Insert a  admin user
INSERT INTO user (id, username, password, role) VALUES (1, 'admin', '$2a$10$jsZ1apRiMPFJdDFgoA8EXu9QSSijncPPsEVLBv/uWqZzPb0Id/IYC', 'ROLE_ADMIN');

-- Create bus routes
CREATE TABLE bus_route (
    id INT PRIMARY KEY AUTO_INCREMENT,
    route_name VARCHAR(255) NOT NULL
);
-- Insert  bus routes
INSERT INTO bus_route (id, route_name) VALUES (1, 'Route A');
INSERT INTO bus_route (id, route_name) VALUES (2, 'Route B');

-- Create buses
CREATE TABLE bus (
    id INT PRIMARY KEY AUTO_INCREMENT,
    reg_number VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    route_id INT,
    FOREIGN KEY (route_id) REFERENCES bus_route(id)
);


-- Insert sample buses
INSERT INTO bus (id, reg_number, type, route_id) VALUES (1, 'ABC123', 'Deluxe', 1);
INSERT INTO bus (id, reg_number, type, route_id) VALUES (2, 'XYZ789', 'Ordinary', 2);

-- Create bus schedules
CREATE TABLE bus_schedule (
    id INT PRIMARY KEY AUTO_INCREMENT,
    bus_id INT,
    route_id INT,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    FOREIGN KEY (bus_id) REFERENCES bus(id),
    FOREIGN KEY (route_id) REFERENCES bus_route(id)
);

-- Insert sample bus schedules
INSERT INTO bus_schedule (id, bus_id, route_id, start_time, end_time) VALUES (1, 1, 1, '08:00:00', '10:00:00');
INSERT INTO bus_schedule (id, bus_id, route_id, start_time, end_time) VALUES (2, 2, 2, '09:00:00', '11:00:00');

-- Create stored procedure
CREATE ALIAS IF NOT EXISTS GetRouteWiseBusDetails FOR "com.bus.management.config.BusProcedure.getRouteWiseBusDetails";