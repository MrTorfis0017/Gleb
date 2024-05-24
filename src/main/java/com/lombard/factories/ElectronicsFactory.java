package com.lombard.factories;

import com.lombard.dtos.ElectronicsDto;
import com.lombard.entities.Electronics;

public class ElectronicsFactory {

    private ElectronicsFactory() {
    }

    public static ElectronicsDto createElectronicsDto(Electronics electronics) {
        return ElectronicsDto.builder()
                .id(electronics.getId())
                .brand(electronics.getBrand())
                .model(electronics.getModel())
                .price(electronics.getPrice())
                .build();

    }

    public static Electronics createElectronics(ElectronicsDto electronics) {
        return Electronics.builder()
                .id(electronics.getId())
                .brand(electronics.getBrand())
                .model(electronics.getModel())
                .price(electronics.getPrice())
                .build();

    }
}
