package com.lombard.service;


import com.lombard.dtos.CarPartsDto;
import com.lombard.entities.CarParts;
import com.lombard.entities.Discount;
import com.lombard.repositories.CarPartsRepository;
import com.lombard.repositories.DiscountRepository;
import com.lombard.services.CarPartsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CarPartsServiceTest {

    @InjectMocks
    private CarPartsService carPartsService;

    @Mock
    private CarPartsRepository carPartsRepository;
    @Mock
    private DiscountRepository discountRepository;

    @Test
    public void getInfoTest() {
        CarParts carParts = data();
        when(carPartsRepository.getReferenceById(1L)).thenReturn(carParts);
        String actualResult = carPartsService.getInfo(1L);
        assertEquals("Part number: 123, Compatability: Some compatability", actualResult);
    }

    @Test
    public void getByIdTest() {
        CarParts carParts = data();
        when(carPartsRepository.getReferenceById(1L)).thenReturn(carParts);
        CarPartsDto actualResult = carPartsService.getById(1L);
        assertEquals(carParts.getId(), actualResult.getId());
    }

    @Test
    public void addDiscountTest() {
        CarParts carParts = data();
        Discount discount = new Discount();
        discount.setId(1L);
        discount.setDiscountPercentage(0.5);
        when(carPartsRepository.getReferenceById(1L)).thenReturn(carParts);
        when(discountRepository.save(any())).thenReturn(discount);
        carParts.setDiscount(discount);
        when(carPartsRepository.save(any())).thenReturn(carParts);
        CarPartsDto actualResult = carPartsService.addDiscount(1L, 0.5);
        assertEquals(carParts.getPrice()*0.5, actualResult.getPrice());
    }

    private CarParts data() {
        return CarParts.builder()
                .id(1L)
                .price(200.0)
                .partNumber("123")
                .compatability("Some compatability")
                .build();
    }
}
