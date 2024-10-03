package com.microservice_transaction.adapter.driving.http.mapper.response;

import com.microservice_transaction.adapter.driving.http.dto.response.SupplyResponse;
import com.microservice_transaction.domain.model.Supply;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISupplyResponseMapper {

    SupplyResponse supplyToSupplyResponse(Supply supply);

}
