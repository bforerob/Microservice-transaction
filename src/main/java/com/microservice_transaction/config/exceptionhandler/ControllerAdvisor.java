package com.microservice_transaction.config.exceptionhandler;


import com.microservice_transaction.config.ExceptionMessage;
import com.microservice_transaction.domain.exception.NegativeArticleIdException;
import com.microservice_transaction.domain.exception.NegativeQuantityException;
import com.microservice_transaction.domain.exception.NullFieldException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {

    @ExceptionHandler(NullFieldException.class)
    public ResponseEntity<ExceptionResponse> handleNullFieldException(NullFieldException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                String.format(ExceptionMessage.NULL_FIELD_EXCEPTION_MESSAGE, exception.getMessage()),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }


    @ExceptionHandler(NegativeArticleIdException.class)
    public ResponseEntity<ExceptionResponse> handleNegativeArticleIdException(NegativeArticleIdException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                ExceptionMessage.NEGATIVE_ARTICLE_ID_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(NegativeQuantityException.class)
    public ResponseEntity<ExceptionResponse> handleNegativeQuantityException(NegativeQuantityException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                ExceptionMessage.NEGATIVE_QUANTITY_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }



}
