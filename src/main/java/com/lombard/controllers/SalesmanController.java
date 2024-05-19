package com.lombard.controllers;

import com.lombard.dtos.SalesmanDto;
import com.lombard.services.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lombard/warehouse/register")
public class SalesmanController {

    private final RegisterService registerService;

    @PostMapping("/salesman")
    public SalesmanDto registerSalesman(@RequestBody SalesmanDto salesmanDto) {
        return registerService.registerSalesman(salesmanDto);
    }

}
