package com.lombard.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SalesmanDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String phone;
}
