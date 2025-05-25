package com.usecase.delivery.service;

import com.usecase.delivery.entity.Delivery;
import com.usecase.delivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository repo;
    public Delivery createDelivery(Delivery delivery) {
        return repo.save(delivery);
    }
    public Delivery updateStatus(Long id, String status) {
        Optional<Delivery> optional = repo.findById(id);
        if (optional.isPresent()) {
            Delivery delivery = optional.get();
            delivery.setStatus(status);
            return repo.save(delivery);
        } else {
            throw new RuntimeException("Delivery with ID " + id + " not found.");
        }
    }

    public List<Delivery> getAllDeliveries() {
        return repo.findAll();
    }

    public Delivery getDeliveryById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + id));
    }
}
