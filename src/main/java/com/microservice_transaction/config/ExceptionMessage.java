package com.microservice_transaction.config;

public class ExceptionMessage {

    private ExceptionMessage() { throw new IllegalStateException("Utility class"); }

    public static final String NULL_FIELD_EXCEPTION_MESSAGE = "Field %s cannot be null.";
    public static final String NEGATIVE_ARTICLE_ID_EXCEPTION_MESSAGE = "Article id cannot be negative.";
    public static final String NEGATIVE_QUANTITY_EXCEPTION_MESSAGE = "Quantity cannot be negative.";


}
