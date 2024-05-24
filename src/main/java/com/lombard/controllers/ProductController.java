package com.lombard.controllers;

import com.lombard.dtos.CarPartsDto;
import com.lombard.dtos.ElectronicsDto;
import com.lombard.dtos.GardenToolsDto;
import com.lombard.services.CarPartsService;
import com.lombard.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lombard/warehouse/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create/car-parts")
    public CarPartsDto createCarPatsProduct(@RequestBody CarPartsDto product) {
        return productService.createCarPartsProduct(product);
    }

    @PostMapping("/create/electronics")
    public ElectronicsDto createElectronicsProduct(@RequestBody ElectronicsDto product) {
        return productService.createElectronicsProduct(product);
    }

    @PostMapping("/create/garden-tools")
    public GardenToolsDto createGardenToolsProduct(@RequestBody GardenToolsDto product) {
        return productService.createGardenToolsProduct(product);
    }
}
