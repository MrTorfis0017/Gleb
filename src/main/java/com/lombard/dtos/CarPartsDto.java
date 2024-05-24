package com.lombard.dtos;

import com.lombard.strategy.PricingStrategy;
import com.lombard.strategy.RegularPricingStrategy;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarPartsDto implements Product {

    private Long id;

    private String partNumber;

    private String compatability;

    private Double price;

    private PricingStrategy pricingStrategy;

    public double getPrice() {
        if (pricingStrategy == null) {
            pricingStrategy = new RegularPricingStrategy();
        }
        return pricingStrategy.calculatePrice(price);
    }
}
