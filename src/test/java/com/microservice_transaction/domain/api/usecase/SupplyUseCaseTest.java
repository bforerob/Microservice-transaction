package com.microservice_transaction.domain.api.usecase;

import com.microservice_transaction.domain.exception.NegativeArticleIdException;
import com.microservice_transaction.domain.exception.NegativeQuantityException;
import com.microservice_transaction.domain.model.Supply;
import com.microservice_transaction.domain.spi.ISupplyPersistencePort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SupplyUseCaseTest {

    @Mock
    private ISupplyPersistencePort supplyPersistencePort;

    @InjectMocks
    private SupplyUseCase supplyUseCase;

    @Test
    @DisplayName("given a supply with valid data, should be added successfully")
    void When_SupplyInformationIsCorrect_Expect_SupplyAddedSuccessfully() {

        Supply supply = new Supply(1L, 1L, 10);

        when(supplyPersistencePort.addSupply(supply)).thenReturn(supply);

        Supply result = supplyUseCase.addSupply(supply);

        assertNotNull(result);
        assertEquals(supply.getId(), result.getId());
        assertEquals(supply, result);
    }

    @Test
    @DisplayName("given a supply with a negative articleId, should throw NegativeArticleIdException")
    void When_ArticleIdIsNegative_Expect_NegativeArticleIdException() {

        Supply supply = new Supply(1L, -1L, 10);

        assertThrows(NegativeArticleIdException.class, () -> supplyUseCase.addSupply(supply),
                "addSupply did not throw the expected NegativeArticleIdException");
    }

    @Test
    @DisplayName("given a supply with a negative quantity, should throw NegativeQuantityException")
    void When_QuantityIsNegative_Expect_NegativeQuantityException() {

        Supply supply = new Supply(1L, 1L, -10);

        assertThrows(NegativeQuantityException.class, () -> supplyUseCase.addSupply(supply),
                "addSupply did not throw the expected NegativeQuantityException");
    }

}