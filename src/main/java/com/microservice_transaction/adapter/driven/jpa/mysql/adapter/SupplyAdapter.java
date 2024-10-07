package com.microservice_transaction.adapter.driven.jpa.mysql.adapter;

import com.microservice_transaction.adapter.driven.jpa.mysql.entity.SupplyEntity;
import com.microservice_transaction.adapter.driven.jpa.mysql.mapper.ISupplyEntityMapper;
import com.microservice_transaction.adapter.driven.jpa.mysql.repository.ISupplyRepository;
import com.microservice_transaction.domain.model.Supply;
import com.microservice_transaction.domain.spi.ISupplyPersistencePort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
public class SupplyAdapter implements ISupplyPersistencePort {

    private final ISupplyRepository supplyRepository;
    private final ISupplyEntityMapper supplyEntityMapper;


    @Override
    public Supply addSupply(Supply supply) {

        SupplyEntity savedSupply = supplyRepository.save(supplyEntityMapper.supplyToSupplyEntity(supply));


        return supplyEntityMapper.supplyEntityToSupply(savedSupply);
    }

    @Override
    public Optional<LocalDate> getNextSupplyArrivalDate(Long articleId) {
        return supplyRepository.findTopByArticleIdAndArrivedFalseOrderByArrivalDateAsc(articleId)
                .map(SupplyEntity::getArrivalDate);
    }
}
