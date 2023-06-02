package com.example.chorushop.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class CompanyReq {

    @NotNull
    @Schema(description = "회사명" )
    private String companyName;

    @NotNull
    @Schema(description = "사업자 번호")
    private String companyNum;

    @NotNull
    @Schema(description = "대표자명")
    private String representative;

    @NotNull
    @Schema(description = "업종")
    private String bizType;

    @NotNull
    @Schema(description = "주소")
    private String address;

}
