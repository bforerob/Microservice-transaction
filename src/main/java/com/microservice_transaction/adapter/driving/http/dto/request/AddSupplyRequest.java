package com.microservice_transaction.adapter.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddSupplyRequest {

    String name;
    Integer quantity;

}
