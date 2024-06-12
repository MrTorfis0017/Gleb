package com.lombard.strategy;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DiscountPricingStrategy implements PricingStrategy {

    private Long id;

    private Double discount;

    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * (1 - discount);
    }

}
