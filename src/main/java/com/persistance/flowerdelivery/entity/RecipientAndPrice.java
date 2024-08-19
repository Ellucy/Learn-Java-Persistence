package com.persistance.flowerdelivery.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RecipientAndPrice {

    private String recipientName;
    private BigDecimal price;

    //Need a constructor for CriteriaBuilder
}
