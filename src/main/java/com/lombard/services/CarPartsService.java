package com.lombard.services;

import com.lombard.adapters.CarPartsAdapter;
import com.lombard.dtos.CarPartsDto;
import com.lombard.entities.CarParts;
import com.lombard.entities.Discount;
import com.lombard.factories.CarPartsFactory;
import com.lombard.repositories.CarPartsRepository;
import com.lombard.repositories.DiscountRepository;
import com.lombard.strategy.DiscountPricingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarPartsService {

    private final CarPartsRepository carPartsRepository;

    private final DiscountRepository discountRepository;

    public String getInfo(Long id) {
        CarParts carParts = carPartsRepository.getReferenceById(id);
        CarPartsAdapter carPartsAdapter = new CarPartsAdapter(CarPartsFactory.createCarPartsDto(carParts));
        return carPartsAdapter.getDescription();
    }

    public CarPartsDto getById(Long id) {
        return CarPartsFactory.createCarPartsDto(carPartsRepository.getReferenceById(id));
    }

    public CarPartsDto addDiscount(Long id, Double discount) {
        CarParts carParts = carPartsRepository.getReferenceById(id);
        Discount discountEntity = new Discount();
        discountEntity.setDiscountPercentage(discount);
        carParts.setDiscount(discountRepository.save(discountEntity));
        carParts = carPartsRepository.save(carParts);
        return CarPartsFactory.createCarPartsDto(carParts);
    }
}
