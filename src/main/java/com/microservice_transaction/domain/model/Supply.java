package com.microservice_transaction.domain.model;

public class Supply {

    Long id;
    String name;
    Integer quantity;

    public Supply(Long id, String name, Integer quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
