package com.example.chorushop.domain.product.web;

import com.example.chorushop.domain.product.dto.ProductReq;
import com.example.chorushop.domain.product.usecase.ProductUseCase;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController implements ProductContract {

    private final ProductUseCase productUseCase;

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK")
    })
    @Override
    @PostMapping
    public Long create(@RequestParam(value = "company-id") Long companyId, @RequestBody ProductReq req) {
        return productUseCase.creatProduct(companyId, req);
    }
}
