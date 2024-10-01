package com.microservice_transaction.config.feign.client;

import com.microservice_transaction.adapter.driving.http.dto.request.AddSupplyRequest;
import com.microservice_transaction.config.feign.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "stock-microservice", url = "http://localhost:9090/article", configuration = FeignClientConfig.class)
public interface ArticleFeignClient {

    @PostMapping("/increment")
    void incrementStock(@RequestBody AddSupplyRequest request);

}

