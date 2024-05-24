package com.lombard.factories;

import com.lombard.dtos.CarPartsDto;
import com.lombard.entities.CarParts;

public class CarPartsFactory {

    private CarPartsFactory() {
    }

    public static CarPartsDto createCarPartsDto(CarParts carParts) {
        return CarPartsDto.builder()
                .id(carParts.getId())
                .compatability(carParts.getCompatability())
                .partNumber(carParts.getPartNumber())
                .price(carParts.getPrice())
                .pricingStrategy(null)
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
