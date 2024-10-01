package com.microservice_transaction.domain.spi;

import com.microservice_transaction.domain.model.Supply;

public interface ISupplyPersistencePort {

    Supply addSupply(Supply supply);


}
