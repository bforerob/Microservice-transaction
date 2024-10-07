package com.microservice_transaction.adapter.driving.http.controller;

import com.microservice_transaction.adapter.driven.jpa.mysql.entity.SupplyEntity;
import com.microservice_transaction.adapter.driven.jpa.mysql.repository.ISupplyRepository;
import com.microservice_transaction.adapter.driving.http.dto.request.AddSupplyRequest;
import com.microservice_transaction.adapter.driving.http.dto.response.NextSupplyResponse;
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
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/supply")
@RequiredArgsConstructor
public class SupplyRestControllerAdapter {

    private final ISupplyServicePort supplyService;
    private final ISupplyRequestMapper supplyRequestMapper;
    private final ISupplyResponseMapper supplyResponseMapper;
    private final CategoryService categoryService;
    private final ISupplyRepository supplyRepository;

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

    @GetMapping("/article/{articleId}/next-supply")
    public ResponseEntity<String> getNextSupply(@PathVariable Long articleId) {
        Optional<LocalDate> nextSupplyDate = supplyService.getNextSupplyArrivalDate(articleId);

        if (nextSupplyDate.isPresent()) {
            return ResponseEntity.ok("El próximo suministro está programado para: " + nextSupplyDate.get());
        } else {
            // Si no hay suministro, devolvemos un mensaje personalizado
            return ResponseEntity.ok("No se tiene registro de un próximo suministro.");
        }
    }

}
