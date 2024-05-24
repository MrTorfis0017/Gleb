package com.lombard.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "GARDEN_TOOLS")
public class GardenTools {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TOOL_TYPE")
    private String toolType;

    @Column(name = "MATERIAL")
    private String material;

    @Column(name = "PRICE")
    private Double price;
}
