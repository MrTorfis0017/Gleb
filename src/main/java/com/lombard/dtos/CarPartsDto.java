package com.lombard.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CarPartsDto implements Product {

    private Long id;

    private String partNumber;

    private String compatability;

    private Double price;
}
