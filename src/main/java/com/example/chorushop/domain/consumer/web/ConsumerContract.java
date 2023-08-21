package com.example.chorushop.domain.consumer.web;

import com.example.chorushop.domain.consumer.dto.ConsumerCreateReq;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "고객 API", description = "고객 등록, 목록 조회, 조회, 수정, 삭제 등 API")
public interface ConsumerContract {

    /*
    *
    * 1. 고객 등록
    * 2. 고객 목록 조회
    * 3. 고객 조회
    * 4. 고객 정보 수정
    * 5. 고객 삭제
    *
    * */


    String create(ConsumerCreateReq req);



}
