package com.microservice_transaction.config.feign.service;

import com.microservice_transaction.adapter.driving.http.dto.request.IncrementStockRequest;
import com.microservice_transaction.config.feign.client.ArticleFeignClient;
import com.microservice_transaction.domain.model.Supply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final ArticleFeignClient articleFeignClient;

    public void incrementStock(IncrementStockRequest request) {
        articleFeignClient.incrementStock(request);
    }

}
