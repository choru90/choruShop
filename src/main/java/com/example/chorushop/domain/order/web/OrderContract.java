package com.example.chorushop.domain.order.web;

import com.example.chorushop.domain.order.dto.CompanyOrderRes;
import com.example.chorushop.domain.order.dto.ConsumerOrderRes;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = " 주문 API", description = "주문 등록, 조회, 삭제, 수정 API")
public interface OrderContract {

    // 등록
    void create();
    // 수정
    void update();
    // 취소
    void cancel();
    // 회사별 주문 목록 조회
    List<CompanyOrderRes> getListByCompanyId(Long companyId);
    // 유저 주문 조회
    List<ConsumerOrderRes> getListByConsumerId(Long consumerId);
}
