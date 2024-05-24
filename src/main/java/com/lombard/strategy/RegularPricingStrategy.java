package com.lombard.strategy;

public class RegularPricingStrategy implements PricingStrategy {
    private Long id;
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice;
    }
}
