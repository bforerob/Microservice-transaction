package com.microservice_transaction.domain.util;

public class DomainConstants {

    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    public enum Field{
        ARTICLE_ID,
        QUANTITY,
        ARRIVAL_DATE,
        ARRIVED
    }

}
