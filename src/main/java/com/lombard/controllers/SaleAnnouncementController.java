package com.lombard.controllers;

import com.lombard.dtos.SaleAnnouncementDto;
import com.lombard.services.SaleAnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lombard/warehouse/sale-announcement")
public class SaleAnnouncementController {

    private final SaleAnnouncementService saleAnnouncementService;

    @PostMapping("/create")
    public SaleAnnouncementDto createSaleAnnouncement(@RequestBody SaleAnnouncementDto saleAnnouncementDto) {
        return saleAnnouncementService.createSaleAnnouncement(saleAnnouncementDto);
    }
}
