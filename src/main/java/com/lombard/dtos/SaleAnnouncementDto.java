package com.lombard.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
public class SaleAnnouncementDto {

    private Long id;

    private Date createDate;

    private Date approveDate;

    private String description;

    private double interestRate;

    private SaleAnnouncementStatus saleAnnouncementStatus;

    private SalesmanDto salesmanDto;

    private Product product;

    private ProductType productType;
}
