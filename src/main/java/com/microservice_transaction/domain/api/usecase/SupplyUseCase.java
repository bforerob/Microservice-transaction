package com.microservice_transaction.domain.api.usecase;

import com.microservice_transaction.domain.api.ISupplyServicePort;
import com.microservice_transaction.domain.model.Supply;
import com.microservice_transaction.domain.spi.ISupplyPersistencePort;

public class SupplyUseCase implements ISupplyServicePort {

    private final ISupplyPersistencePort supplyPersistencePort;

    public SupplyUseCase(ISupplyPersistencePort supplyPersistencePort) {
        this.supplyPersistencePort = supplyPersistencePort;
    }

    @Override
    public Supply addSupply(Supply supply) {


        return supplyPersistencePort.addSupply(supply);
    }
}
