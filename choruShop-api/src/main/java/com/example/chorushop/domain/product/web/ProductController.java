package com.example.chorushop.domain.product.web;

import com.example.chorushop.domain.product.usecase.ProductUseCase;
import com.example.chorushop.dto.ProductReq;
import com.example.chorushop.dto.ProductRes;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController implements ProductContract {

    private final ProductUseCase useCase;

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK")
    })
    @Override
    @PostMapping
    public Long create(@RequestParam(value = "company-id") Long companyId, @RequestBody ProductReq req) {
        return useCase.creatProduct(companyId, req);
    }
    @Override
    @GetMapping("/{id}")
    public ProductRes get(@PathVariable(value = "id") Long id) {
        return useCase.get(id);
    }

    @Override
    @GetMapping
    public List<ProductRes> getList(@RequestParam(value = "company-id") Long companyId) {
        return useCase.getList(companyId);
    }

    @Override
    @PatchMapping("{id}")
    public ProductRes update(@PathVariable(value = "id") Long id, @RequestBody ProductReq req) {
        return useCase.update(id, req);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(Long id) {
        useCase.delete(id);
    }
}
