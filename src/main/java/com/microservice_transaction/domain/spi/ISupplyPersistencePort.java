package com.microservice_transaction.domain.spi;

import com.microservice_transaction.domain.model.Supply;

import java.time.LocalDate;
import java.util.Optional;

public interface ISupplyPersistencePort {

    Supply addSupply(Supply supply);
    Optional<LocalDate> getNextSupplyArrivalDate(Long articleId);


}
