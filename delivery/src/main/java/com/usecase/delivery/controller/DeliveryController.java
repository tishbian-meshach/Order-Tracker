package com.usecase.delivery.controller;

import com.usecase.delivery.entity.Delivery;
import com.usecase.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService service;

    @GetMapping
    public List<Delivery> getAllDeliveries(){
        return service.getAllDeliveries();
    }

    @GetMapping("/{id}")
    public Delivery getDeliveryById(@PathVariable Long id){
        return service.getDeliveryById(id);
    }

    @PutMapping("/{id}/status")
    public Delivery updateDeliveryStatus(@PathVariable Long id, @RequestBody Delivery delivery) {
        return service.updateStatus(id, delivery.getStatus());
    }

    @PostMapping
    public Delivery createDelivery(@RequestBody Delivery delivery) {
        return service.createDelivery(delivery);
    }
}
