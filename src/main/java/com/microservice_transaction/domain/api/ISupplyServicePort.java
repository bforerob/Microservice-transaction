package com.microservice_transaction.domain.api;

import com.microservice_transaction.domain.model.Supply;

import java.time.LocalDate;
import java.util.Optional;

public interface ISupplyServicePort {

    Supply addSupply(Supply supply);
    Optional<LocalDate> getNextSupplyArrivalDate(Long articleId);

}
