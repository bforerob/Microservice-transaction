package com.microservice_transaction.adapter.driving.http.mapper.request;

import com.microservice_transaction.adapter.driving.http.dto.request.AddSupplyRequest;
import com.microservice_transaction.adapter.driving.http.dto.request.IncrementStockRequest;
import com.microservice_transaction.domain.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ISupplyRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "arrived", ignore = true)
    Supply addSupplyRequestToSupply(AddSupplyRequest addSupplyRequest);

    IncrementStockRequest addSupplyRequestToIncrementStockRequest(AddSupplyRequest addSupplyRequest);

}
