package com.microservice_transaction.domain.model;

import com.microservice_transaction.domain.exception.NullFieldException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupplyTest {

    @Test
    @DisplayName("given a supply with a null articleId, should throw NullFieldException")
    void When_ArticleIdIsNull_Expect_NullFieldException() {
        assertThrows(NullFieldException.class, () -> new Supply(1L, null, 10),
                "Supply constructor did not throw the expected NullFieldException when articleId is null");
    }

    @Test
    @DisplayName("given a supply with a null quantity, should throw NullFieldException")
    void When_QuantityIsNull_Expect_NullFieldException() {
        assertThrows(NullFieldException.class, () -> new Supply(1L, 1L, null),
                "Supply constructor did not throw the expected NullFieldException when quantity is null");
    }

}