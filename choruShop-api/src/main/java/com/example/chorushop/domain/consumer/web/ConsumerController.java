package com.example.chorushop.domain.consumer.web;

import com.example.chorushop.domain.consumer.dto.ConsumerCreateReq;
import com.example.chorushop.domain.consumer.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("consumer")
@RestController
@RequiredArgsConstructor
public class ConsumerController implements ConsumerContract {

    private final ConsumerService service;
    @Override
    @PostMapping
    public String create(ConsumerCreateReq req) {
        return service.create(req);
    }
}
