package com.example.chorushop.domain.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record CompanyRes (
       @Schema(description = "id") Long id,
       @Schema(description = "회사명") String companyName,
       @Schema(description = "사업자 번호") String companyNum,
       @Schema(description = "대표자명") String representative,
       @Schema(description = "업종")String bizType,
       @Schema(description = "주소")String address){
}
