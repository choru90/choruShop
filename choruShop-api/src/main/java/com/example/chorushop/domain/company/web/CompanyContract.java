package com.example.chorushop.domain.company.web;

import com.example.chorushop.domain.company.dto.CompanyReq;
import com.example.chorushop.domain.company.dto.CompanyRes;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "회사 API", description = "회사 등록, 조회, 삭제, 수정 API")
public interface CompanyContract {

    /*
    * 1. 회사 등록
    * 2. 회사 조회
    * 3. 회사 삭제
    * 4. 회사 수정
    *
    * */

    Long create(CompanyReq req);

    CompanyRes get(Long id);

    void delete(Long id);

    CompanyRes update(Long id ,CompanyReq req);

    List<CompanyRes> getList();






}
