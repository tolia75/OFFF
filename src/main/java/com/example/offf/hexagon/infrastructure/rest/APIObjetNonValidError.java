package com.example.offf.hexagon.infrastructure.rest;

import org.springframework.http.HttpStatus;

public class APIObjetNonValidError extends ApiError {

    APIObjetNonValidError(HttpStatus status, String message) {
        super(status, message);
    }
}
