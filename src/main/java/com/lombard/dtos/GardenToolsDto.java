package com.lombard.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GardenToolsDto implements Product {

    private Long id;

    private String toolType;

    private String material;

    private Double price;
}
