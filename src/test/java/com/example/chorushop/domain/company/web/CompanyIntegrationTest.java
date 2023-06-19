package com.example.chorushop.domain.company.web;

import com.example.chorushop.domain.company.dto.CompanyReq;
import com.example.chorushop.domain.company.entity.Company;
import com.example.chorushop.domain.company.repository.CompanyRepository;
import com.example.chorushop.domain.company.web.data.CompanyDataSetUp;
import com.example.chorushop.utils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "spring.profiles.active=test")
@ActiveProfiles("test")
class CompanyIntegrationTest {

    @LocalServerPort
    int port;

    @MockBean
    CompanyRepository repository;

    @Autowired
    CompanyDataSetUp setUp;

    @BeforeEach
    public void cleanUp() {
        RestAssured.port = port;
    }


    /*
    * company create
    * case1 : 200 -  정상 케이스
    * */
    @Test
    @DisplayName("company 생성 : 200")
    void createTest200(){
        Long id = 1L;

        doReturn(new Company(id,null, null, null, null, null))
                .when(repository).save(any());

        ExtractableResponse<Response> result = RestUtils.request()
                                                        .body(getReq())
                                                        .log().all()
                                                        .when()
                                                        .post("/company")
                                                        .then().log().all().extract();

        verify(repository, times(1)).save(any());
        assertEquals(HttpStatus.OK.value(), result.statusCode());
        assertEquals(id, result.body().as(Long.class));
    }
    /*
    * update
    * case1 : 200 - 수정이 되어지는 것
    * case2 : 404 - NOT_FOUND
    *
    * */
    @Test
    @DisplayName("company 수정 : 200 ")
    void updateTest200(){
        Company company = setUp.createCompany();

        doReturn(Optional.of(company)).when(repository).findById(anyLong());

        ExtractableResponse<Response> result = RestUtils.request()
                .body(getReq())
                .log().all()
                .when()
                .patch("/company/{id}", company.getId())
                .then().log().all().extract();

        assertEquals(HttpStatus.OK.value(), result.statusCode());
        assertEquals(company.getId(), result.body().jsonPath().getLong("id"));
    }

    @Test
    @DisplayName("company 수정 : 404 - 수정하고자 하는 company 정보가 없는 경우")
    void updateTest404(){
        Long id = 1123453L;

        ExtractableResponse<Response> result = RestUtils.request()
                .body(getReq())
                .log().all()
                .when()
                .patch("/company/{id}", id)
                .then().log().all().extract();

        assertEquals(HttpStatus.NOT_FOUND.value(), result.statusCode());
    }

    @Test
    @DisplayName("company 삭제 : 200")
    void deleteTest200(){
        Company company = setUp.createCompany();

        doReturn(Optional.of(company)).when(repository).findById(anyLong());

        ExtractableResponse<Response> result = RestUtils.request()
                .body(getReq())
                .log().all()
                .when()
                .delete("/company/{id}", company.getId())
                .then().log().all().extract();

        assertEquals(HttpStatus.OK.value(), result.statusCode());
        verify(repository, times(1)).delete(any());
    }

    @Test
    @DisplayName("company 삭제 : 404 - 삭제하고자 하는 company가 없는 경우")
    void deleteTest404(){
        Long id = 9999999L;
        ExtractableResponse<Response> result = RestUtils.request()
                .body(getReq())
                .log().all()
                .when()
                .delete("/company/{id}", id)
                .then().log().all().extract();

        assertEquals(HttpStatus.NOT_FOUND.value(), result.statusCode());
    }

    private CompanyReq getReq() {
        return new CompanyReq("무한상사",
                "127-08-12345",
                "김대표",
                "유통",
                "서울시 강남구");
    }
}