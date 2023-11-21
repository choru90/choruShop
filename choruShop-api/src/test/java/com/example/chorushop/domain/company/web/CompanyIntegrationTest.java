package com.example.chorushop.domain.company.web;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "spring.profiles.active=test")
@ActiveProfiles("test")
@Tag("IntegrationTest")
class CompanyIntegrationTest {

    @LocalServerPort
    int port;

    @Autowired
    CompanyRepository repository;

    @Autowired
    CompanyDataSetUp setUp;
    @Autowired
    DataBaseSetUp dataBaseSetUp;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
        dataBaseSetUp.clean();
    }


    /*
    * company create
    * case1 : 200 -  정상 케이스
    * */
    @Test
    @DisplayName("company 생성 : 200")
    void createTest200(){
        ExtractableResponse<Response> result = RestUtils.request()
                                                        .body(getReq())
                                                        .log().all()
                                                        .when()
                                                        .post("/company")
                                                        .then().log().all().extract();

        assertEquals(HttpStatus.OK.value(), result.statusCode());
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

        ExtractableResponse<Response> result = RestUtils.request()
                .body(getReq())
                .log().all()
                .when()
                .delete("/company/{id}", company.getId())
                .then().log().all().extract();

        assertEquals(HttpStatus.OK.value(), result.statusCode());
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

    /*
    * 회사 조회
    * case1 : 200 정상 - 조회되어짐
    * case2 : 404 - company가 없는 경우
    *
    * */
    @Test
    @DisplayName("company 조회 : 200 - 정상적으로 조회됨")
    void getTest200(){
        Company company = setUp.createCompany();

        ExtractableResponse<Response> result = RestUtils.request()
                .body(getReq())
                .log().all()
                .when()
                .get("/company/{id}", company.getId())
                .then().log().all().extract();

        assertEquals(HttpStatus.OK.value(), result.statusCode());
        assertEquals(company.getId(), result.body().jsonPath().getLong("id"));
        assertEquals(company.getCompanyName(), result.body().jsonPath().getString("companyName"));
        assertEquals(company.getCompanyNum(), result.body().jsonPath().getString("companyNum"));
        assertEquals(company.getRepresentative(), result.body().jsonPath().getString("representative"));
        assertEquals(company.getBizType(), result.body().jsonPath().getString("bizType"));
        assertEquals(company.getAddress(), result.body().jsonPath().getString("address"));
    }

    @Test
    @DisplayName("company 조회 : 404 - company가 없는 경우")
    void getTest404(){
        Long id = 99999999L;
        ExtractableResponse<Response> result = RestUtils.request()
                .body(getReq())
                .log().all()
                .when()
                .get("/company/{id}", id)
                .then().log().all().extract();

        assertEquals(HttpStatus.NOT_FOUND.value(), result.statusCode());
    }
    /*
    * 회사 목록 조회
    * case1 : 200 목록 조회됨
    * case2 : 404 회사 목록이 없는경우
    * */

    @Test
    @DisplayName("company 목록조회 : 200 - 정상 company 목록조회")
    void getListTest200(){
        List<Company> companies = setUp.creatCompanies();
        Company company1 = companies.get(0);
        Company company2 = companies.get(1);
        Company company3 = companies.get(2);


        ExtractableResponse<Response> result = RestUtils.request()
                .body(getReq())
                .log().all()
                .when()
                .get("/company")
                .then().log().all().extract();

        assertEquals(HttpStatus.OK.value(), result.statusCode());
        List<Long> ids = result.body().jsonPath().getList("id", Long.class);
        assertEquals(company1.getId(),ids.get(0));
        assertEquals(company2.getId(),ids.get(1));
        assertEquals(company3.getId(),ids.get(2));
        List<String> companyNames = result.body().jsonPath().getList("companyName", String.class);
        assertEquals(company1.getCompanyName(), companyNames.get(0));
        assertEquals(company2.getCompanyName(), companyNames.get(1));
        assertEquals(company3.getCompanyName(), companyNames.get(2));
        List<String> companyNums = result.body().jsonPath().getList("companyNum", String.class);
        assertEquals(company1.getCompanyNum(), companyNums.get(0));
        assertEquals(company2.getCompanyNum(), companyNums.get(1));
        assertEquals(company3.getCompanyNum(), companyNums.get(2));
        List<String> representatives = result.body().jsonPath().getList("representative", String.class);
        assertEquals(company1.getRepresentative(), representatives.get(0));
        assertEquals(company2.getRepresentative(), representatives.get(1));
        assertEquals(company3.getRepresentative(), representatives.get(2));
        List<String> bizTypes = result.body().jsonPath().getList("bizType", String.class);
        assertEquals(company1.getBizType(), bizTypes.get(0));
        assertEquals(company2.getBizType(), bizTypes.get(1));
        assertEquals(company3.getBizType(), bizTypes.get(2));
        List<String> addresses = result.body().jsonPath().getList("address", String.class);
        assertEquals(company1.getAddress(), addresses.get(0));
        assertEquals(company2.getAddress(), addresses.get(1));
        assertEquals(company3.getAddress(), addresses.get(2));
    }

    @Test
    @DisplayName("company 목록조회 : 404 - company 목록이 없는 경우")
    void getListTest404(){
        ExtractableResponse<Response> result = RestUtils.request()
                .body(getReq())
                .log().all()
                .when()
                .get("/company")
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