package com.microservice_transaction.adapter.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class AddSupplyRequest {

    private final Long articleId;
    private final Integer quantity;
    private final LocalDate arrivalDate;



}
