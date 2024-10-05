package com.microservice_transaction.domain.model;

import com.microservice_transaction.domain.exception.NullFieldException;
import com.microservice_transaction.domain.util.DomainConstants;

import java.time.LocalDate;
import java.util.Objects;

public class Supply {

    private final Long id;
    private final Long articleId;
    private final Integer quantity;
    private LocalDate arrivalDate;
    private Boolean arrived;


    public Supply(Long id, Long articleId, Integer quantity, LocalDate arrivalDate, Boolean arrived) {
        this.id = id;
        this.articleId = Objects.requireNonNull(articleId, () -> {
            throw new NullFieldException(DomainConstants.Field.ARTICLE_ID.toString());
        });
        this.quantity = Objects.requireNonNull(quantity, () -> {
            throw new NullFieldException(DomainConstants.Field.QUANTITY.toString());
        });

        this.arrivalDate = Objects.requireNonNull(arrivalDate, () -> {
            throw new NullFieldException(DomainConstants.Field.ARRIVAL_DATE.toString());
        });
        this.arrived = arrived;


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

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public Boolean getArrived() {
        return arrived;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setArrived(Boolean arrived) {
        this.arrived = arrived;
    }
}
