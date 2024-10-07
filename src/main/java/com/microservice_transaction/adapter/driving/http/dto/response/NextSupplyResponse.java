package com.microservice_transaction.adapter.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class NextSupplyResponse {
    private LocalDate nextArrivalDate;
}
