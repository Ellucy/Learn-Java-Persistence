package com.persistance.flowerdelivery.repository;

import com.persistance.flowerdelivery.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

    Boolean existsPlantByPlantIdAndDeliveryCompleted(Long plantId, Boolean delivered);

    @Query("SELECT d.completed FROM Plant p JOIN p.delivery d WHERE p.plantId = :plantId")
    Boolean deliveryCompleted(@Param("plantId") Long plantId);

//    //to return a wrapper class, you may need to construct it as a projection
//    @Query("select new java.lang.Boolean(p.delivery.completed) from Plant p where p.plantId = :plantId")
//    Boolean deliveryCompletedBoolean(Long plantId);

    //we can do this entirely with the method name
    List<Plant> findByPriceLessThan(BigDecimal price);

}
