package com.microservice_transaction.config.feign.service;

import com.microservice_transaction.adapter.driving.http.dto.request.AddSupplyRequest;
import com.microservice_transaction.config.feign.client.ArticleFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final ArticleFeignClient articleFeignClient;

    public void incrementStock(AddSupplyRequest request) {
        articleFeignClient.incrementStock(request);
    }

}
