package com.example.chorushop.domain.company.web;

import com.example.chorushop.domain.company.dto.CompanyReq;
import com.example.chorushop.domain.company.entity.Company;
import com.example.chorushop.domain.company.repository.CompanyRepository;
import com.example.chorushop.utils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "spring.profiles.active=test")
@ActiveProfiles("test")
class CompanyIntegrationTest {

    @LocalServerPort
    int port;

    @BeforeEach
    public void cleanUp() {
        RestAssured.port = port;
    }

    @MockBean
    CompanyRepository repository;
    /*
    * company create
    * 200 -  정상 케이스
    * */

    @Test
    @DisplayName("company 생성 : 200")
    void createTest200(){

        CompanyReq req = new CompanyReq("무한상사",
                            "127-08-12345",
                            "김대표",
                                "유통",
                                "서울시 강남구");

        doReturn(new Company(1L,null, null, null, null, null))
                .when(repository).save(any());

        ExtractableResponse<Response> result = RestUtils.request()
                                                        .body(req)
                                                        .log().all()
                                                        .when()
                                                        .post("/company")
                                                        .then().log().all().extract();

        verify(repository, times(1)).save(any());
        assertEquals(HttpStatus.OK.value(), result.statusCode());
        assertEquals(1L, result.body().as(Long.class));

    }
}