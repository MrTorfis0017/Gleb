package com.lombard.adapters;

import com.lombard.dtos.CarPartsDto;
import com.lombard.dtos.ProductAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CarPartsAdapter implements ProductAdapter {

    private final CarPartsDto carPartsDto;

    @Override
    public String getDescripton() {
        return "Part number: " + carPartsDto.getPartNumber() + ", Compatability: " + carPartsDto.getCompatability();
    }
}
