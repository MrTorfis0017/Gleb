package com.lombard.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lombard.dtos.ProductType;
import com.lombard.dtos.SaleAnnouncementDto;
import com.lombard.services.SaleAnnouncementService;
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

@WebMvcTest(controllers = SaleAnnouncementController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class SaleAnnouncementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SaleAnnouncementService saleAnnouncementService;

    @Test
    public void registerSalesmanTest() throws Exception {
        SaleAnnouncementDto saleAnnouncementDto = SaleAnnouncementDto.builder().
                id(1L)
                .description("Some desc")
                .interestRate(5.0)
                .productType(ProductType.CAR_PARTS)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(saleAnnouncementDto);
        when(saleAnnouncementService.createSaleAnnouncement(any())).thenReturn(saleAnnouncementDto);
        ResultActions resultActions = this.mockMvc.perform(post("/lombard/warehouse/sale-announcement/create").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk());
        assertEquals(objectMapper.writeValueAsString(saleAnnouncementDto), resultActions.andReturn().getResponse().getContentAsString());
    }
}
