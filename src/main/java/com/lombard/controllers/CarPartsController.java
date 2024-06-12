package com.lombard.controllers;

import com.lombard.dtos.CarPartsDto;
import com.lombard.services.CarPartsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lombard/warehouse/product/car-parts")
public class CarPartsController {

    private final CarPartsService carPartsService;

    @GetMapping("/info/{id}")
    public String getInfo(@PathVariable("id") Long id) {
        return carPartsService.getInfo(id);
    }

    @GetMapping("/{id}")
    public CarPartsDto getProduct(@PathVariable("id") Long id) {
        return carPartsService.getById(id);
    }

    @PostMapping("/discount/{id}")
    public CarPartsDto addDiscount(Double discount, @PathVariable(name = "id") Long id) {
        return carPartsService.addDiscount(id,discount);
    }
}
