package com.virgingames.virgininfo;

import com.virgingames.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class VirginSteps {

    @Step("Getting Jackpot Virgin Bingo Information")
    public ValidatableResponse getJackpotInfo(){
    return SerenityRest.given().log().all()
           .queryParam(EndPoints.CURRENCY)
           .when()
           .get(EndPoints.JACKPOT_BINGO)
           .then();
    }
}
