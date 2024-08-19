package com.persistance.flowerdelivery.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.type.YesNoConverter;

import java.time.LocalDateTime;
import java.util.List;

@NamedQuery(
        name="Delivery.findByName",
        query = "select d from Delivery d where d.recipientName = :recipientName"
)

@Entity
@Getter
@Setter
@Data
public class Delivery {

    @Id
    @GeneratedValue
    private Long deliveryId;

    @Nationalized
    @Column(name = "recipient_name")
    private String recipientName;

    @Column(name = "address_full", length = 500)
    private String address;

    @Column(name = "delivery_time")
    private LocalDateTime deliveryTime;

    @Convert(converter = YesNoConverter.class)
    private Boolean completed;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Plant> plants;

    public Delivery(String recipientName, String address, LocalDateTime deliveryTime) {
        this.recipientName = recipientName;
        this.address = address;
        this.deliveryTime = deliveryTime;
    }
}
