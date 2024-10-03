package com.microservice_transaction.config;

import com.microservice_transaction.adapter.driven.jpa.mysql.adapter.SupplyAdapter;
import com.microservice_transaction.adapter.driven.jpa.mysql.mapper.ISupplyEntityMapper;
import com.microservice_transaction.adapter.driven.jpa.mysql.repository.ISupplyRepository;
import com.microservice_transaction.domain.api.ISupplyServicePort;
import com.microservice_transaction.domain.api.usecase.SupplyUseCase;
import com.microservice_transaction.domain.spi.ISupplyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ISupplyEntityMapper supplyEntityMapper;
    private final ISupplyRepository supplyRepository;

    @Bean
    public ISupplyPersistencePort supplyPersistencePort() {
        return new SupplyAdapter(supplyRepository, supplyEntityMapper);
    }

    @Bean
    public ISupplyServicePort supplyServicePort(){
        return new SupplyUseCase(supplyPersistencePort());
    }

}
