package com.example.chorushop.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum RestApiExceptionCode {

    NOT_FOUND(HttpStatus.NOT_FOUND, "ERROR-404");


    private HttpStatus status;
    private String code;

}
