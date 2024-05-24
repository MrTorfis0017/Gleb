package com.lombard.factories;

import com.lombard.dtos.GardenToolsDto;
import com.lombard.entities.GardenTools;

public class GardenToolsFactory {

    private GardenToolsFactory() {
    }

    public static GardenToolsDto createGardenToolsDto(GardenTools gardenTools) {
        return GardenToolsDto.builder()
                .id(gardenTools.getId())
                .toolType(gardenTools.getToolType())
                .material(gardenTools.getMaterial())
                .price(gardenTools.getPrice())
                .build();
    }

    public static GardenTools createGardenTools(GardenToolsDto gardenToolsDto) {
        return GardenTools.builder()
                .id(gardenToolsDto.getId())
                .toolType(gardenToolsDto.getToolType())
                .material(gardenToolsDto.getMaterial())
                .price(gardenToolsDto.getPrice())
                .build();
    }
}
