package com.lombard.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lombard.dtos.CarPartsDto;
import com.lombard.dtos.ElectronicsDto;
import com.lombard.dtos.GardenToolsDto;
import com.lombard.entities.CarParts;
import com.lombard.entities.Electronics;
import com.lombard.entities.GardenTools;
import com.lombard.repositories.CarPartsRepository;
import com.lombard.repositories.ElectronicsRepository;
import com.lombard.repositories.GardenToolsRepository;
import com.lombard.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private CarPartsRepository carPartsRepository;
    @Mock
    private ElectronicsRepository electronicsRepository;

    @Mock
    private GardenToolsRepository gardenToolsRepository;

    @Test
    public void createCarPartsProductTest() throws JsonProcessingException {
        CarParts carParts = CarParts.builder()
                .id(1L)
                .partNumber("123")
                .compatability("Some compatability info")
                .price(300.0)
                .build();

        CarPartsDto carPartsDto = CarPartsDto.builder()
                .id(1L)
                .partNumber("123")
                .compatability("Some compatability info")
                .price(300.0)
                .build();
        when(carPartsRepository.save(any())).thenReturn(carParts);

        CarPartsDto actualResult = productService.createCarPartsProduct(carPartsDto);
        assertEquals(new ObjectMapper().writeValueAsString(carPartsDto), new ObjectMapper().writeValueAsString(actualResult));
    }

    @Test
    public void createElectronicsProductTest() throws JsonProcessingException {
        Electronics electronics = Electronics.builder()
                .id(1L)
                .brand("Some brand")
                .model("Some model")
                .price(300.0)
                .build();

        ElectronicsDto electronicsDto = ElectronicsDto.builder()
                .id(1L)
                .brand("Some brand")
                .model("Some model")
                .price(300.0)
                .build();
        when(electronicsRepository.save(any())).thenReturn(electronics);

        ElectronicsDto actualResult = productService.createElectronicsProduct(electronicsDto);
        assertEquals(new ObjectMapper().writeValueAsString(electronicsDto), new ObjectMapper().writeValueAsString(actualResult));
    }

    @Test
    public void createGardenToolsProductTest() throws JsonProcessingException {
        GardenTools gardenTools = GardenTools.builder()
                .id(1L)
                .toolType("Tool type")
                .material("Material")
                .price(300.0)
                .build();

        GardenToolsDto gardenToolsDto = GardenToolsDto.builder()
                .id(1L)
                .toolType("Tool type")
                .material("Material")
                .price(300.0)
                .build();
        when(gardenToolsRepository.save(any())).thenReturn(gardenTools);

        GardenToolsDto actualResult = productService.createGardenToolsProduct(gardenToolsDto);
        assertEquals(new ObjectMapper().writeValueAsString(gardenToolsDto), new ObjectMapper().writeValueAsString(actualResult));
    }
}
