package com.lombard.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ElectronicsDto implements Product {

    private Long id;

    private String brand;

    private String model;

    private Double price;
}
