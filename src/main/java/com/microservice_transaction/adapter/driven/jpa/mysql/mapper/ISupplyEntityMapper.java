package com.microservice_transaction.adapter.driven.jpa.mysql.mapper;

import com.microservice_transaction.adapter.driven.jpa.mysql.entity.SupplyEntity;
import com.microservice_transaction.adapter.driving.http.dto.request.IncrementStockRequest;
import com.microservice_transaction.domain.model.Supply;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISupplyEntityMapper {

    Supply supplyEntityToSupply(SupplyEntity supplyEntity);
    SupplyEntity supplyToSupplyEntity(Supply supply);
    IncrementStockRequest supplyEntityToIncrementStockRequest(SupplyEntity supplyEntity);

}
