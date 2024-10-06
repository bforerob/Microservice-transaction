package com.microservice_transaction.config;

import com.microservice_transaction.adapter.driven.jpa.mysql.entity.SupplyEntity;
import com.microservice_transaction.adapter.driven.jpa.mysql.mapper.ISupplyEntityMapper;
import com.microservice_transaction.adapter.driven.jpa.mysql.repository.ISupplyRepository;
import com.microservice_transaction.config.feign.client.ArticleFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class SupplyScheduler {

    private final ISupplyRepository supplyRepository;
    private final ArticleFeignClient stockService;
    private final ISupplyEntityMapper supplyEntityMapper;


    @Scheduled(cron = "0 0 0 * * *")
    public void updateStockBasedOnArrivalDate() {
        List<SupplyEntity> supplies = supplyRepository.findByArrivalDateBeforeAndArrivedFalse(LocalDate.now());

        for (SupplyEntity supplyEntity : supplies) {
            stockService.incrementStock(supplyEntityMapper.supplyEntityToIncrementStockRequest(supplyEntity));

            supplyEntity.setArrived(true);
            supplyRepository.save(supplyEntity);
        }
    }
}

