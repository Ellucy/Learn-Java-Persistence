package com.persistance.flowerdelivery.repository;

import com.persistance.flowerdelivery.entity.Delivery;
import com.persistance.flowerdelivery.entity.Plant;
import com.persistance.flowerdelivery.entity.RecipientAndPrice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeliveryRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void persistDelivery(Delivery d) {
        entityManager.persist(d); //write d to the database
//        d.setAddress(d.getAddress()); //will update database
//        d.setCompleted(false);
//        d.setPlants(d.getPlants());
//        d.setDeliveryTime(LocalDateTime.now());
//        d.setRecipientName(d.getRecipientName());
    }

    public void findDelivery(Long id) {
        Delivery d = entityManager.find(Delivery.class, id); //retrieve an instance by its key
    }

    public void getPlantReference(Long deliveryId, Long plantId) {
        Delivery d = entityManager.find(Delivery.class, deliveryId);
        Plant plantReference = entityManager.getReference(Plant.class, plantId);
        d.getPlants().add(plantReference);
    }

    public void mergeDelivery(Delivery detachedDelivery) {
//        detachedDelivery.setCompleted(true);
        Delivery managedDelivery = entityManager.merge(detachedDelivery);
//        detachedDelivery.setCompleted(false); //will have no effect on database
//        managedDelivery.setCompleted(true); //will overwrite false
    }

    public void deleteDelivery(Long id) {
        Delivery d = entityManager.find(Delivery.class, id); //retrieve an instance by its key
        entityManager.remove(d); //will delete row from database
    }

    public List<Delivery> findDeliveriesByName(String name) {
        TypedQuery<Delivery> query = entityManager.createNamedQuery("Delivery.findByName", Delivery.class);
        query.setParameter("recipientName", name);
        return query.getResultList();
    }

    public RecipientAndPrice getBill(Long deliveryId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPrice> query = cb.createQuery(RecipientAndPrice.class);
        Root<Plant> root = query.from(Plant.class);
        query.select(
                        cb.construct(
                                RecipientAndPrice.class,
                                root.get("delivery").get("name"),
                                cb.sum(root.get("price"))))
                .where(cb.equal(root.get("delivery").get("id"), deliveryId));
        return entityManager.createQuery(query).getSingleResult();
    }

}
