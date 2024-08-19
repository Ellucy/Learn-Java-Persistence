package com.persistance.flowerdelivery.service;

import com.persistance.flowerdelivery.entity.Delivery;
import com.persistance.flowerdelivery.entity.RecipientAndPrice;
import com.persistance.flowerdelivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persistDelivery(delivery);
        return delivery.getDeliveryId();
    }

    public RecipientAndPrice getBill(Long deliveryId){
        return deliveryRepository.getBill(deliveryId);
    }
}
