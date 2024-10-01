package com.microservice_transaction.domain.model;

public class Supply {

    private final Long id;
    private final Long articleId;
    private final Integer quantity;

    public Supply(Long id, Long articleId, Integer quantity) {
        this.id = id;
        this.articleId = articleId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
