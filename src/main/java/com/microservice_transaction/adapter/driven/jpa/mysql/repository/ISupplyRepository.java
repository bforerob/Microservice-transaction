package com.microservice_transaction.adapter.driven.jpa.mysql.repository;

import com.microservice_transaction.adapter.driven.jpa.mysql.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplyRepository extends JpaRepository<SupplyEntity, Long> {
}
