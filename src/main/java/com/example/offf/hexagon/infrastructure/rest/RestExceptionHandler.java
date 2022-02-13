package com.example.offf.hexagon.infrastructure.rest;

import com.example.offf.hexagon.domain.exception.ObjetMetierNonValideException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<Object> handleObjetMetierNonValideException(ObjetMetierNonValideException exception) {
        APIObjetNonValidError apiObjetNonValidError = new APIObjetNonValidError(HttpStatus.UNPROCESSABLE_ENTITY, exception.getMessage());
        return buildResponseEntity(apiObjetNonValidError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
