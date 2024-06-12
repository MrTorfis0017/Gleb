package com.lombard.service;

import com.lombard.dtos.SalesmanDto;
import com.lombard.entities.Salesman;
import com.lombard.repositories.SalesmanRepository;
import com.lombard.services.RegisterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegisterServiceTest {

    @InjectMocks
    private RegisterService registerService;

    @Mock
    private SalesmanRepository salesmanRepository;

    @Test
    public void registerSalesman() {
        SalesmanDto request = SalesmanDto.builder().
                id(null).firstName("FirstName").lastName("LastName").phone("0772318457").build();
        Salesman response = Salesman.builder().
                id(1L).firstName("FirstName").lastName("LastName").phone("0772318457").build();
        when(salesmanRepository.save(any())).thenReturn(response);
        registerService.registerSalesman(request);
    }
}
