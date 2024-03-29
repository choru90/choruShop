package com.example.chorushop.domain.company.web;

import com.example.chorushop.domain.company.dto.CompanyReq;
import com.example.chorushop.domain.company.dto.CompanyRes;
import com.example.chorushop.domain.company.service.CompanyService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("company")
@RequiredArgsConstructor
public class CompanyController implements CompanyContract {

    private final CompanyService service;

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK !!"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND !!"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
    })
    @Override
    @PostMapping
    public Long create(@RequestBody CompanyReq req) {
        return service.create(req);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }

    @Override
    @PatchMapping("/{id}")
    public CompanyRes update(@PathVariable(value = "id") Long id, CompanyReq req) {
        return service.update(id, req);
    }

    @Override
    @GetMapping("/{id}")
    public CompanyRes get(@PathVariable(value = "id") Long id) {
        return service.get(id);
    }

    @Override
    @GetMapping
    public List<CompanyRes> getList() {
        return service.getList();
    }
}
