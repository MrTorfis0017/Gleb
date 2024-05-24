package com.lombard.services;

import com.lombard.adapters.CarPartsAdapter;
import com.lombard.entities.CarParts;
import com.lombard.factories.CarPartsFactory;
import com.lombard.repositories.CarPartsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarPartsService {

    private final CarPartsRepository carPartsRepository;

    public String getInfo(Long id) {
        CarParts carParts = carPartsRepository.getReferenceById(id);
        CarPartsAdapter carPartsAdapter = new CarPartsAdapter(CarPartsFactory.createCarPartsDto(carParts));
        return carPartsAdapter.getDescripton();
    }
}
