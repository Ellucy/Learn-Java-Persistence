package com.persistance.flowerdelivery.service;

import com.persistance.flowerdelivery.entity.Flower;
import com.persistance.flowerdelivery.entity.Plant;
import com.persistance.flowerdelivery.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantService {

    private PlantRepository plantRepository;

    public Long save(Plant plant){
        return plantRepository.save(plant).getPlantId();
    }

    public Boolean delivered(Long plantId){
        // return plantRepository.deliveryCompleted(id);
        return plantRepository.existsPlantByPlantIdAndDeliveryCompleted(plantId, true);
    }

    public List<Plant> findPlantsBelowPrice(BigDecimal price) {
        return plantRepository.findByPriceLessThan(price);
    }
}
