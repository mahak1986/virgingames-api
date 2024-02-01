package com.virgingames.virgininfo;


import com.virgingames.testbase.TestBase;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.annotations.WithTag;
import net.serenitybdd.annotations.WithTags;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class TagsTest extends TestBase {
    @WithTag("virgingamesfeature:NEGATIVE")
    @Title("Provide a 400 status code when incorrect HTTP method is used to access resource")
    @Test
    public void invalidMethod(){ //Negative test case
        SerenityRest.given()
                .when()
                .post("/jackpots/bingo")
                .then().statusCode(400).log().all();
    }
    @WithTags({
            @WithTag("virgingamesfeature:POSITIVE"),
            @WithTag("virgingamesfeature:SMOKE")
    })
    @Title("This test will verify if a status code of 200 is returned for a GET request")
    @Test
    public void verifyIfStatusCodeIs200(){ //positive test case
        SerenityRest.given()
                .when()
                .get("/jackpots/bingo")
                .then()
                .statusCode(200).log().all();
    }
    @WithTags({
            @WithTag("virgingamesfeature:NEGATIVE"),
            @WithTag("virgingamesfeature:SMOKE")
    })
    @Title("This test will provide an error code 400 when user tries to access an invalid resource")
    @Test
    public void inCorrectResource(){ //Negative test case as incorrect endpoint
        SerenityRest.given()
                .when()
                .get("/jackpots/bingo123")
                .then()
                .statusCode(400).log().all();
    }

}
