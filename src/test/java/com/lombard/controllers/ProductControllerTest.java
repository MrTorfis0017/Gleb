package com.lombard.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lombard.dtos.CarPartsDto;
import com.lombard.dtos.ElectronicsDto;
import com.lombard.dtos.GardenToolsDto;
import com.lombard.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void createCarPartsProductTest() throws Exception {
        CarPartsDto carPartsDto = CarPartsDto.builder()
                .id(1L)
                .partNumber("321")
                .price(300.0)
                .compatability("compatability")
                .build();
        when(productService.createCarPartsProduct(any())).thenReturn(carPartsDto);
        ResultActions resultActions = mockMvc.perform(post("/lombard/warehouse/product/create/car-parts").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(carPartsDto))).andExpect(status().isOk());
        assertEquals(new ObjectMapper().writeValueAsString(carPartsDto), resultActions.andReturn().getResponse().getContentAsString());
    }

    @Test
    public void createElectronicsProductTest() throws Exception {
        ElectronicsDto electronicsDto = ElectronicsDto.builder()
                .id(1L)
                .price(300.0)
                .model("Some model")
                .brand("Some brand")
                .build();
        when(productService.createElectronicsProduct(any())).thenReturn(electronicsDto);
        ResultActions resultActions = mockMvc.perform(post("/lombard/warehouse/product/create/electronics").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(electronicsDto))).andExpect(status().isOk());
        assertEquals(new ObjectMapper().writeValueAsString(electronicsDto), resultActions.andReturn().getResponse().getContentAsString());
    }

    @Test
    public void createGardenToolsProductTest() throws Exception {
        GardenToolsDto gardenToolsDto = GardenToolsDto.builder()
                .id(1L)
                .price(300.0)
                .material("Material")
                .toolType("ToolType")
                .build();
        when(productService.createGardenToolsProduct(any())).thenReturn(gardenToolsDto);
        ResultActions resultActions = mockMvc.perform(post("/lombard/warehouse/product/create/garden-tools").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(gardenToolsDto))).andExpect(status().isOk());
        assertEquals(new ObjectMapper().writeValueAsString(gardenToolsDto), resultActions.andReturn().getResponse().getContentAsString());
    }
}
