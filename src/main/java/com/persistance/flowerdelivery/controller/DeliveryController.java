package com.persistance.flowerdelivery.controller;

import com.persistance.flowerdelivery.entity.Delivery;
import com.persistance.flowerdelivery.entity.RecipientAndPrice;
import com.persistance.flowerdelivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

//    @GetMapping
//    public void findDeliveries() {
//
//    }
//
//    @GetMapping("/{id}")
//    public void findDeliveryById(@PathVariable Long id) {
//
//    }

    @PostMapping
    @Transactional
    public Long scheduleDelivery(@RequestBody Delivery delivery) {
        return deliveryService.save(delivery);
    }

    @GetMapping("/bill/{deliveryId}")
    public RecipientAndPrice getBill(@PathVariable Long deliveryId) {
        return deliveryService.getBill(deliveryId);
    }
}
