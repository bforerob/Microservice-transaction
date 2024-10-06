package com.microservice_transaction.adapter.driving.http.controller;

import com.microservice_transaction.adapter.driving.http.dto.request.AddSupplyRequest;
import com.microservice_transaction.adapter.driving.http.dto.response.SupplyResponse;
import com.microservice_transaction.adapter.driving.http.mapper.request.ISupplyRequestMapper;
import com.microservice_transaction.adapter.driving.http.mapper.response.ISupplyResponseMapper;
import com.microservice_transaction.config.feign.service.CategoryService;
import com.microservice_transaction.domain.api.ISupplyServicePort;
import com.microservice_transaction.domain.model.Supply;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/supply")
@RequiredArgsConstructor
public class SupplyRestControllerAdapter {

    private final ISupplyServicePort supplyService;
    private final ISupplyRequestMapper supplyRequestMapper;
    private final ISupplyResponseMapper supplyResponseMapper;
    private final CategoryService categoryService;

    @Transactional
    @PostMapping("/")
    public ResponseEntity<SupplyResponse> addSupply(@RequestBody AddSupplyRequest addSupplyRequest) {

        Supply supply = supplyRequestMapper.addSupplyRequestToSupply(addSupplyRequest);
        supply.setArrived(supply.getArrivalDate().isBefore(LocalDate.now().plusDays(1)));
        SupplyResponse createdSupply = supplyResponseMapper.supplyToSupplyResponse(supplyService.addSupply(supply));

        if(supply.getArrived().equals(Boolean.TRUE)){
            categoryService.incrementStock(supplyRequestMapper.addSupplyRequestToIncrementStockRequest(addSupplyRequest));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(createdSupply);

    }

}
