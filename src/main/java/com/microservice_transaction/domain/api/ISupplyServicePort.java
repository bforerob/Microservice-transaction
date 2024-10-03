package com.microservice_transaction.domain.api;

import com.microservice_transaction.domain.model.Supply;

public interface ISupplyServicePort {

    Supply addSupply(Supply supply);

}
