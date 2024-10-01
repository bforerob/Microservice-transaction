package com.microservice_transaction.adapter.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SupplyResponse {

    Long id;
    String name;
    Integer quantity;

}
