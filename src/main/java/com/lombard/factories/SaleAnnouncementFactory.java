package com.lombard.factories;

import com.lombard.dtos.*;
import com.lombard.entities.CarParts;
import com.lombard.entities.Electronics;
import com.lombard.entities.GardenTools;
import com.lombard.entities.SaleAnnouncement;
import com.lombard.repositories.CarPartsRepository;
import com.lombard.repositories.ElectronicsRepository;
import com.lombard.repositories.GardenToolsRepository;

public class SaleAnnouncementFactory {

    private SaleAnnouncementFactory() {
    }

    public static SaleAnnouncementDto createSaleAnnouncementDto(SaleAnnouncement saleAnnouncement, CarPartsRepository carPartsRepository, ElectronicsRepository electronicsRepository, GardenToolsRepository gardenToolsRepository) {
        Product product = null;
        if (saleAnnouncement.getProductType() == ProductType.CAR_PARTS)
            product = CarPartsFactory.createCarPartsDto(carPartsRepository.getReferenceById(saleAnnouncement.getProductId()));
        else if (saleAnnouncement.getProductType() == ProductType.ELECTRONICS)
            product = ElectronicsFactory.createElectronicsDto(electronicsRepository.getReferenceById(saleAnnouncement.getProductId()));
        else if (saleAnnouncement.getProductType() == ProductType.GARDEN_TOOLS) {
            product = GardenToolsFactory.createGardenToolsDto(gardenToolsRepository.getReferenceById(saleAnnouncement.getProductId()));
        }
        return SaleAnnouncementDto.builder()
                .id(saleAnnouncement.getId())
                .createDate(saleAnnouncement.getCreateDate())
                .approveDate(saleAnnouncement.getApproveDate())
                .description(saleAnnouncement.getDescription())
                .interestRate(saleAnnouncement.getInterestRate())
                .saleAnnouncementStatus(saleAnnouncement.getSaleAnnouncementStatus())
                .salesmanDto(SalesmanFactory.createSalesmanDto(saleAnnouncement.getSalesman()))
                .product(product)
                .productType(saleAnnouncement.getProductType())
                .build();
    }

    public static SaleAnnouncement createSaleAnnouncement(SaleAnnouncementDto saleAnnouncementDto, CarPartsRepository carPartsRepository, ElectronicsRepository electronicsRepository, GardenToolsRepository gardenToolsRepository) {
        Long productId = -1L;
        if (saleAnnouncementDto.getProductType() == ProductType.CAR_PARTS) {
            CarParts carPartsToSave = CarPartsFactory.createCarParts((CarPartsDto) saleAnnouncementDto.getProduct());
            productId = carPartsRepository.save(carPartsToSave).getId();
        } else if (saleAnnouncementDto.getProductType() == ProductType.GARDEN_TOOLS) {
            GardenTools gardenTools = GardenToolsFactory.createGardenTools((GardenToolsDto) saleAnnouncementDto.getProduct());
            productId = gardenToolsRepository.save(gardenTools).getId();
        } else if (saleAnnouncementDto.getProductType() == ProductType.ELECTRONICS) {
            Electronics electronics = ElectronicsFactory.createElectronics((ElectronicsDto) saleAnnouncementDto.getProduct());
            productId = electronicsRepository.save(electronics).getId();
        }


        return SaleAnnouncement.builder()
                .id(saleAnnouncementDto.getId())
                .createDate(saleAnnouncementDto.getCreateDate())
                .approveDate(saleAnnouncementDto.getApproveDate())
                .description(saleAnnouncementDto.getDescription())
                .interestRate(saleAnnouncementDto.getInterestRate())
                .saleAnnouncementStatus(saleAnnouncementDto.getSaleAnnouncementStatus())
                .salesman(SalesmanFactory.createSalesman(saleAnnouncementDto.getSalesmanDto()))
                .productId(productId)
                .productType(saleAnnouncementDto.getProductType())
                .build();
    }


}
