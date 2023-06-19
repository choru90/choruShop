package com.example.chorushop.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(RestApiException.class)
    public ResponseEntity<RestApiErrorResponse> handleResponseStatusException(final RestApiException ex) {

        RestApiErrorResponse restApiErrorResponse = new RestApiErrorResponse();

        return new ResponseEntity<>(restApiErrorResponse, ex.getCode().getStatus());
    }
}
