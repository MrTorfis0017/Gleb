package com.lombard.dtos;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CarPartsDto.class, name = "carParts"),
        @JsonSubTypes.Type(value = ElectronicsDto.class, name = "electronics"),
        @JsonSubTypes.Type(value = GardenToolsDto.class, name = "gardenTools")
})
public interface Product {
}
