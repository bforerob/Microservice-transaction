package com.microservice_transaction.domain.model;

import com.microservice_transaction.domain.exception.NullFieldException;
import com.microservice_transaction.domain.util.DomainConstants;

import java.util.Objects;

public class Supply {

    private final Long id;
    private final Long articleId;
    private final Integer quantity;

    public Supply(Long id, Long articleId, Integer quantity) {
        this.id = id;
        this.articleId = Objects.requireNonNull(articleId, () -> {
            throw new NullFieldException(DomainConstants.Field.ARTICLE_ID.toString());
        });
        this.quantity = Objects.requireNonNull(quantity, () -> {
            throw new NullFieldException(DomainConstants.Field.QUANTITY.toString());
        });
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
