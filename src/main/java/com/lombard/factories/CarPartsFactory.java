package com.lombard.factories;

import com.lombard.dtos.CarPartsDto;
import com.lombard.entities.CarParts;
import com.lombard.strategy.DiscountPricingStrategy;
import com.lombard.strategy.RegularPricingStrategy;

public class CarPartsFactory {

    private CarPartsFactory() {
    }

    public static CarPartsDto createCarPartsDto(CarParts carParts) {
        DiscountPricingStrategy discountPricingStrategy = new DiscountPricingStrategy();
        if (carParts.getDiscount() != null) {
            discountPricingStrategy = new DiscountPricingStrategy();
            discountPricingStrategy.setDiscount(carParts.getDiscount().getDiscountPercentage());
            discountPricingStrategy.setId(carParts.getDiscount().getId());
        }
        return CarPartsDto.builder()
                .id(carParts.getId())
                .compatability(carParts.getCompatability())
                .partNumber(carParts.getPartNumber())
                .price(carParts.getPrice())
                .pricingStrategy(discountPricingStrategy.getDiscount() != null ? discountPricingStrategy : new RegularPricingStrategy())
                .build();
    }

    public static CarParts createCarParts(CarPartsDto carParts) {
        return CarParts.builder()
                .id(carParts.getId())
                .compatability(carParts.getCompatability())
                .partNumber(carParts.getPartNumber())
                .price(carParts.getPrice())
                .discount(null)
                .build();
    }
}
