package com.lombard.services;

import com.lombard.dtos.SalesmanDto;
import com.lombard.entities.Salesman;
import com.lombard.factories.SalesmanFactory;
import com.lombard.repositories.SalesmanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final SalesmanRepository salesmanRepository;

    public SalesmanDto registerSalesman(SalesmanDto salesmanDto) {
        Salesman savedSalesman = salesmanRepository.save(SalesmanFactory.createSalesman(salesmanDto));
        return SalesmanFactory.createSalesmanDto(savedSalesman);
    }
}
