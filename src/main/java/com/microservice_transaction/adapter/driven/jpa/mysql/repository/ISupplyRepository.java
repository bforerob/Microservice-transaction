package com.microservice_transaction.adapter.driven.jpa.mysql.repository;

import com.microservice_transaction.adapter.driven.jpa.mysql.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ISupplyRepository extends JpaRepository<SupplyEntity, Long> {

    List<SupplyEntity> findByArrivalDateBeforeAndArrivedFalse(LocalDate arrivalDate);
    Optional<SupplyEntity> findTopByArticleIdAndArrivedFalseOrderByArrivalDateAsc(Long articleId);

}
