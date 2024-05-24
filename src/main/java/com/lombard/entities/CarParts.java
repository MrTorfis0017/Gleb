package com.lombard.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CAR_PARTS")
public class CarParts {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PART_NUMBER")
    private String partNumber;

    @Column(name = "COMPATABILITY")
    private String compatability;

    @Column(name = "PRICE")
    private Double price;

    @OneToOne
    @JoinColumn(name = "DISCOUNT_ID")
    private Discount discount;
}
