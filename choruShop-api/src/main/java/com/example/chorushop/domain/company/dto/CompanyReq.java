package com.example.chorushop.domain.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record CompanyReq (
        @Schema(description = "회사명" ) @NotNull String companyName,
        @Schema(description = "사업자 번호") @NotNull String companyNum,
        @Schema(description = "대표자명") @NotNull String representative,
        @Schema(description = "업종") @NotNull String bizType,
        @Schema(description = "주소") @NotNull String address){

}
