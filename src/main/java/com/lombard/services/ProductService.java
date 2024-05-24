package com.lombard.services;

import com.lombard.dtos.CarPartsDto;
import com.lombard.dtos.ElectronicsDto;
import com.lombard.dtos.GardenToolsDto;
import com.lombard.entities.CarParts;
import com.lombard.entities.Electronics;
import com.lombard.entities.GardenTools;
import com.lombard.factories.CarPartsFactory;
import com.lombard.factories.ElectronicsFactory;
import com.lombard.factories.GardenToolsFactory;
import com.lombard.repositories.CarPartsRepository;
import com.lombard.repositories.ElectronicsRepository;
import com.lombard.repositories.GardenToolsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CarPartsRepository carPartsRepository;

    private final ElectronicsRepository electronicsRepository;

    private final GardenToolsRepository gardenToolsRepository;

    public CarPartsDto createCarPartsProduct(CarPartsDto product) {
        CarParts carParts = CarPartsFactory.createCarParts(product);
        return CarPartsFactory.createCarPartsDto(carPartsRepository.save(carParts));
    }

    public ElectronicsDto createElectronicsProduct(ElectronicsDto product) {
        Electronics electronics = ElectronicsFactory.createElectronics(product);
        return ElectronicsFactory.createElectronicsDto(electronicsRepository.save(electronics));
    }

    public GardenToolsDto createGardenToolsProduct(GardenToolsDto product) {
        GardenTools gardenTools = GardenToolsFactory.createGardenTools(product);
        return GardenToolsFactory.createGardenToolsDto(gardenToolsRepository.save(gardenTools));
    }
}
