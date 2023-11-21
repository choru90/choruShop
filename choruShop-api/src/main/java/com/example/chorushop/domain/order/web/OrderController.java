package com.example.chorushop.domain.order.web;

import com.example.chorushop.domain.order.dto.CompanyOrderRes;
import com.example.chorushop.domain.order.dto.ConsumerOrderRes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController implements OrderContract {

    @Override
    @PostMapping
    public void create() {

    }

    @Override
    @PutMapping
    public void update() {

    }

    @Override
    @PostMapping("cancel")
    public void cancel() {

    }

    @Override
    @GetMapping("company")
    public List<CompanyOrderRes> getListByCompanyId(Long companyId) {
        return null;
    }

    @Override
    @GetMapping("consumer")
    public List<ConsumerOrderRes> getListByConsumerId(Long consumerId) {
        return null;
    }
}
