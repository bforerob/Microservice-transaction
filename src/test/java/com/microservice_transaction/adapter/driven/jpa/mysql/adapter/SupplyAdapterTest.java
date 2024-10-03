package com.microservice_transaction.adapter.driven.jpa.mysql.adapter;

import com.microservice_transaction.adapter.driven.jpa.mysql.entity.SupplyEntity;
import com.microservice_transaction.adapter.driven.jpa.mysql.mapper.ISupplyEntityMapper;
import com.microservice_transaction.adapter.driven.jpa.mysql.repository.ISupplyRepository;
import com.microservice_transaction.domain.model.Supply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SupplyAdapterTest {

    @Mock
    private ISupplyRepository supplyRepository;
    @Mock
    private ISupplyEntityMapper supplyEntityMapper;
    @InjectMocks
    private SupplyAdapter supplyAdapter;

    @Test
    @DisplayName("Given a supply, the supply should be saved correctly")
    void When_SupplyIsCorrect_Expect_SupplySavedSuccessfully() {

        Supply supply = new Supply(1L, 1L, 10);
        SupplyEntity supplyEntity = new SupplyEntity(1L, 1L, 10);

        when(supplyEntityMapper.supplyToSupplyEntity(supply)).thenReturn(supplyEntity);
        when(supplyRepository.save(supplyEntity)).thenReturn(supplyEntity);
        when(supplyEntityMapper.supplyEntityToSupply(supplyEntity)).thenReturn(supply);

        Supply result = supplyAdapter.addSupply(supply);

        assertEquals(result, supply, "Supply was not saved correctly");
    }

}