package com.lombard.adapters;

import com.lombard.dtos.ElectronicsDto;
import com.lombard.dtos.ProductAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ElectronicsAdapter implements ProductAdapter {

    private ElectronicsDto electronics;

    @Override
    public String getDescripton() {
        return "Brand: " + electronics.getBrand() + ", Model: " + electronics.getModel();
    }
}
