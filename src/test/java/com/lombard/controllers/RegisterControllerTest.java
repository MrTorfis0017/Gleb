package com.lombard.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lombard.dtos.SalesmanDto;
import com.lombard.services.RegisterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RegisterController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class RegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegisterService registerService;

    @Test
    public void registerSalesmanTest() throws Exception {
        SalesmanDto salesmanDto = SalesmanDto.builder().
                id(null).firstName("FirstName").lastName("LastName").phone("0772318457").build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(salesmanDto);
        salesmanDto.setId(1L);
        when(registerService.registerSalesman(ArgumentMatchers.any())).thenReturn(salesmanDto);
        ResultActions resultActions = this.mockMvc.perform(post("/lombard/warehouse/register/salesman").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk());
        assertEquals(objectMapper.writeValueAsString(salesmanDto), resultActions.andReturn().getResponse().getContentAsString());
    }
}
