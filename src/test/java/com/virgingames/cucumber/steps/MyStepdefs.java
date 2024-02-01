package com.virgingames.cucumber.steps;

import com.virgingames.constants.EndPoints;
import com.virgingames.virgininfo.VirginSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

import java.util.List;

public class MyStepdefs {

    static ValidatableResponse response; //global variable to get the response into the steps.
    static List<String> currency;
    @Steps
    VirginSteps virginSteps;

    @When("User sends a GET request to list endpoint")
    public void userSendsAGETRequestToListEndpoint() {
        response = virginSteps.getJackpotInfo();
        //currency = response.extract().jsonPath().get("data.pots*.currency");

    }

    @Then("User must get back a valid status code {int}")
    public void userMustGetBackAValidStatusCode(int statusCode) {
        response.statusCode(statusCode);

    }

    @Then("User verify the currency as GBP")
    public void userVerifyTheCurrencyAsGBP() {
        currency = response.extract().jsonPath().get("data.pots*.currency");
        for (String currencyR : currency)
        Assert.assertEquals(currencyR, EndPoints.CURRENCY);
    }
}
