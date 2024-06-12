package com.lombard.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lombard.dtos.CarPartsDto;
import com.lombard.services.CarPartsService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CarPartsController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class CarPartsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarPartsService carPartsService;

    @Test
    public void getInfoTest() throws Exception {
        when(carPartsService.getInfo(any())).thenReturn("Some info");
        ResultActions resultActions = mockMvc.perform(get("/lombard/warehouse/product/car-parts/info/1")).andExpect(status().isOk());
        assertEquals("Some info", resultActions.andReturn().getResponse().getContentAsString());
    }

    @Test
    public void getProductTest() throws Exception {
        CarPartsDto carPartsDto = CarPartsDto.builder()
                .id(1L)
                .partNumber("321")
                .price(300.0)
                .compatability("compatability")
                .build();
        when(carPartsService.getById(any())).thenReturn(carPartsDto);
        ResultActions resultActions = mockMvc.perform(get("/lombard/warehouse/product/car-parts/1")).andExpect(status().isOk());
        assertEquals(new ObjectMapper().writeValueAsString(carPartsDto), resultActions.andReturn().getResponse().getContentAsString());
    }

    @Test
    public void addDiscountTest() throws Exception {
        CarPartsDto carPartsDto = CarPartsDto.builder()
                .price(300.0)
                .build();
        when(carPartsService.addDiscount(any(),any())).thenReturn(carPartsDto);
        ResultActions resultActions = mockMvc.perform(post("/lombard/warehouse/product/car-parts/discount/1").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(50.0))).andExpect(status().isOk());
        assertEquals(new ObjectMapper().writeValueAsString(carPartsDto), resultActions.andReturn().getResponse().getContentAsString());
    }
}
