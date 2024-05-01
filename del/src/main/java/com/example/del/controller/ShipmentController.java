package com.example.del.controller;

import com.example.del.entity.Shipment;
import com.example.del.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @GetMapping
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @PostMapping
    public Shipment createShipment(@RequestBody Shipment shipment) {
        return shipmentRepository.save(shipment);
    }
}
