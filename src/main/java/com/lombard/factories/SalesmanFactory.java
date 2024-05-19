package com.lombard.factories;


import com.lombard.dtos.SalesmanDto;
import com.lombard.entities.Salesman;

public class SalesmanFactory {

    private SalesmanFactory() {
    }

    public static Salesman createSalesman(SalesmanDto salesmanDto) {
        return Salesman.builder()
                .id(salesmanDto.getId())
                .firstName(salesmanDto.getFirstName())
                .lastName(salesmanDto.getLastName())
                .phone(salesmanDto.getPhone())
                .build();
    }

    public static SalesmanDto createSalesmanDto(Salesman salesman) {
        return SalesmanDto.builder()
                .id(salesman.getId())
                .firstName(salesman.getFirstName())
                .lastName(salesman.getLastName())
                .phone(salesman.getPhone())
                .build();
    }
}
