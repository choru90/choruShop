package com.example.chorushop.domain.consumer.service;

import com.example.chorushop.domain.consumer.dto.ConsumerCreateReq;
import com.example.chorushop.domain.consumer.entity.Consumer;
import com.example.chorushop.domain.consumer.repository.ConsumerRepository;
import com.example.chorushop.exception.RestApiException;
import com.example.chorushop.exception.RestApiExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ConsumerServiceImpl implements ConsumerService{

    private final ConsumerRepository repository;

    /*
     * 1. 고객 정보를 조회
     * 2. 가입 여부 체크 - emali
     * 3. ID 중복 체크
     * 4. 저장
     */

    @Override
    public String create(ConsumerCreateReq req) {
        checkEmail(req.getEmail());
        checkDuplicateId(req.getLoginId());
        Consumer savedConsumer = repository.save(Consumer.from(req));
        return savedConsumer.getLoginId();
    }

    private void checkEmail(String email){
        if(repository.existsByEmail(email)){
            throw new RestApiException(RestApiExceptionCode.NOT_FOUND, "중복된 email 입니다.");
        }
    }

    private void checkDuplicateId(String loginId){
        if(repository.existsByLoginId(loginId)){
            throw new RestApiException(RestApiExceptionCode.NOT_FOUND, "이미 사용중인 ID입니다.");
        }
    }
}
