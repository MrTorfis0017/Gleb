package com.lombard.entities;

import com.lombard.dtos.ProductType;
import com.lombard.dtos.SaleAnnouncementStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "SALE_ANNOUNCEMENT")
public class SaleAnnouncement {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "APPROVE_DATE")
    private Date approveDate;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "INTEREST_RATE")
    private double interestRate;

    @Column(name = "SALE_STATUS")
    @Enumerated(EnumType.STRING)
    private SaleAnnouncementStatus saleAnnouncementStatus;

    @ManyToOne
    @JoinColumn(name = "SALESMAN_ID")
    private Salesman salesman;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRODUCT_TYPE")
    @Enumerated(EnumType.STRING)
    private ProductType productType;

}
