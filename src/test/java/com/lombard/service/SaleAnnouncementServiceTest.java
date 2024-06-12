package com.lombard.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lombard.dtos.CarPartsDto;
import com.lombard.dtos.ProductType;
import com.lombard.dtos.SaleAnnouncementDto;
import com.lombard.dtos.SalesmanDto;
import com.lombard.entities.CarParts;
import com.lombard.entities.SaleAnnouncement;
import com.lombard.factories.SalesmanFactory;
import com.lombard.repositories.CarPartsRepository;
import com.lombard.repositories.ElectronicsRepository;
import com.lombard.repositories.GardenToolsRepository;
import com.lombard.repositories.SaleAnnouncementRepository;
import com.lombard.services.SaleAnnouncementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SaleAnnouncementServiceTest {

    @InjectMocks
    private SaleAnnouncementService saleAnnouncementService;

    @Mock
    private SaleAnnouncementRepository saleAnnouncementRepository;

    @Mock
    private CarPartsRepository carPartsRepository;

    @Mock
    private ElectronicsRepository electronicsRepository;

    @Mock
    private GardenToolsRepository gardenToolsRepository;

    @Test
    public void createSaleAnnouncementTest() throws JsonProcessingException {
        SaleAnnouncement saleAnnouncement = new SaleAnnouncement();
        saleAnnouncement.setId(1L);
        saleAnnouncement.setDescription("Some desc");
        saleAnnouncement.setInterestRate(5);
        saleAnnouncement.setProductType(ProductType.CAR_PARTS);

        CarPartsDto carPartsDto = CarPartsDto.builder()
                .id(1L)
                .price(300.0)
                .compatability("Compatability")
                .build();

        SalesmanDto salesmanDto = SalesmanDto.builder()
                .id(1L)
                .firstName("First name")
                .lastName("Last name")
                .phone("0668371264")
                .build();

        SaleAnnouncementDto saleAnnouncementDto = SaleAnnouncementDto.builder().
                id(1L)
                .description("Some desc")
                .interestRate(5)
                .product(carPartsDto)
                .productType(ProductType.CAR_PARTS)
                .salesmanDto(salesmanDto)
                .build();

        saleAnnouncement.setId(1L);
        saleAnnouncement.setDescription("Some desc");
        saleAnnouncement.setInterestRate(5);
        saleAnnouncement.setProductType(ProductType.CAR_PARTS);
        saleAnnouncement.setSalesman(SalesmanFactory.createSalesman(salesmanDto));

        CarParts carParts = new CarParts();
        carParts.setId(1L);
        carParts.setPrice(300.0);
        carParts.setCompatability("Compatability");

        when(saleAnnouncementRepository.save(any())).thenReturn(saleAnnouncement);
        when(carPartsRepository.getReferenceById(any())).thenReturn(carParts);
        when(carPartsRepository.save(any())).thenReturn(carParts);

        SaleAnnouncementDto actualResult = saleAnnouncementService.createSaleAnnouncement(saleAnnouncementDto);

        ObjectMapper objectMapper = new ObjectMapper();
        assertEquals(objectMapper.writeValueAsString(saleAnnouncementDto), objectMapper.writeValueAsString(actualResult));
    }
}
