package com.microservice_transaction.adapter.driving.http.controller;

import com.microservice_transaction.adapter.driving.http.dto.request.AddSupplyRequest;
import com.microservice_transaction.adapter.driving.http.dto.response.SupplyResponse;
import com.microservice_transaction.adapter.driving.http.mapper.request.ISupplyRequestMapper;
import com.microservice_transaction.adapter.driving.http.mapper.response.ISupplyResponseMapper;
import com.microservice_transaction.config.feign.service.CategoryService;
import com.microservice_transaction.domain.api.ISupplyServicePort;
import com.microservice_transaction.domain.model.Supply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SupplyRestControllerAdapter.class)
class SupplyRestControllerAdapterTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ISupplyServicePort supplyService;


    @MockBean
    private ISupplyRequestMapper supplyRequestMapper;

    @MockBean
    private ISupplyResponseMapper supplyResponseMapper;

    @MockBean
    private CategoryService categoryService;

    @Test
    @DisplayName("Given a valid supply request, should return created status and supply response")
    void When_SupplyIsCorrect_Expect_ReturnCreatedStatus() throws Exception {

        Supply supply = new Supply(1L, 1L, 10);
        SupplyResponse supplyResponse = new SupplyResponse(1L, 1L, 10);

        when(supplyRequestMapper.addSupplyRequestToSupply(any(AddSupplyRequest.class))).thenReturn(supply);
        when(supplyService.addSupply(any(Supply.class))).thenReturn(supply);
        when(supplyResponseMapper.supplyToSupplyResponse(any(Supply.class))).thenReturn(supplyResponse);

        mockMvc.perform(post("/supply/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"articleId\":1,\"quantity\":10}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.articleId").value(1L))
                .andExpect(jsonPath("$.quantity").value(10));

        verify(supplyService).addSupply(any(Supply.class));
        verify(supplyResponseMapper).supplyToSupplyResponse(any(Supply.class));
    }

}