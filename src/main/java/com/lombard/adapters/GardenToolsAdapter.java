package com.lombard.adapters;

import com.lombard.dtos.GardenToolsDto;
import com.lombard.dtos.ProductAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GardenToolsAdapter implements ProductAdapter {

    private final GardenToolsDto gardenToolsDto;

    @Override
    public String getDescription() {
        return "Tool type:" + gardenToolsDto.getToolType() + ", Material: " + gardenToolsDto.getMaterial();
    }
}
