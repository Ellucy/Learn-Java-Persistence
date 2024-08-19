package com.persistance.flowerdelivery.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flower")
public class Flower extends Plant {

    private String flowerColor;
}
