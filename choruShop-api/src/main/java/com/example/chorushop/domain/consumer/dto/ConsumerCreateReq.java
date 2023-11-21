package com.example.chorushop.domain.consumer.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ConsumerCreateReq {

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private Integer age;

    @NotNull
    private Integer phoneNum;

    @NotNull
    private String address;

    @NotNull
    private String addressDetail;

    @NotNull
    private Integer addressNum;

    @NotNull
    private String loginId;

}
