package com.example.chorushop.exception;

import lombok.Getter;

@Getter
public class RestApiException extends RuntimeException{

    private RestApiExceptionCode code;


    public RestApiException(RestApiExceptionCode code, String message){
        super(message);
        this.code = code;
    }
}
