package com.lombard.services;

import com.lombard.dtos.SaleAnnouncementDto;
import com.lombard.entities.SaleAnnouncement;
import com.lombard.factories.SaleAnnouncementFactory;
import com.lombard.repositories.CarPartsRepository;
import com.lombard.repositories.ElectronicsRepository;
import com.lombard.repositories.GardenToolsRepository;
import com.lombard.repositories.SaleAnnouncementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleAnnouncementService {

    private final SaleAnnouncementRepository saleAnnouncementRepository;

    private final CarPartsRepository carPartsRepository;

    private final ElectronicsRepository electronicsRepository;

    private final GardenToolsRepository gardenToolsRepository;


    public SaleAnnouncementDto createSaleAnnouncement(SaleAnnouncementDto saleAnnouncementDto) {
        SaleAnnouncement saleAnnouncement = saleAnnouncementRepository.save(SaleAnnouncementFactory.createSaleAnnouncement(saleAnnouncementDto, carPartsRepository, electronicsRepository, gardenToolsRepository));
        return SaleAnnouncementFactory.createSaleAnnouncementDto(saleAnnouncement, carPartsRepository, electronicsRepository, gardenToolsRepository);
    }

}
