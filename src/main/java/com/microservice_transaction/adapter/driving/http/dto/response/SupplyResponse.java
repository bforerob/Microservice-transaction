package com.microservice_transaction.adapter.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class SupplyResponse {

    private final Long id;
    private final Long articleId;
    private final Integer quantity;
    private final LocalDate arrivalDate;


}
