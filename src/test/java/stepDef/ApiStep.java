package stepDef;

import pages.ApiPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ApiStep {

    ApiPage apiPage;

    public ApiStep () {
        this.apiPage = new ApiPage();
    }

    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apiPage.prepareUrlFor(url);
     }

    @And("hit api get all list data")
    public void hitApiGetAllListData() {
        apiPage.hitApiGetAllListData();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int status_code) {
        apiPage.validationStatusCodeIsEquals(status_code);
    }

    @Then("validation response body get list user data")
    public void validationResponseBodyGetListEmployeeData() {
        apiPage.validationResponseBodyGetListUserData();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String filename) {
        apiPage.validationResponseJsonWithJSONSchema(filename);
    }

    @And("hit api get data specific")
    public void hitApiGetDataSpecific() {
        apiPage.hitApiGetDataSpecific();
    }

    @Then("validation response body data specific")
    public void validationResponseBodyDataSpecific() {
        apiPage.validationResponseBodyDataSpecific();
    }

    @And("hit api get data wrong id")
    public void hitApiGetDataWrongId() {
        apiPage.hitApiGetDataWrongId();
    }

    @Then("validation response body wrong id")
    public void validationResponseBodyWrongId() {
        apiPage.validationResponseBodyWrongId();
    }

    @And("hit api post create new data")
    public void hitApiPostCreateNewData() {
        apiPage.hitApiPostCreateNewData();
    }

    @Then("validation response body post create new data")
    public void validationResponseBodyPostCreateNewData() {
        apiPage.validationResponseBodyPostCreateNewData();
    }

    @And("hit api delete new data")
    public void hitApiDeleteNewData() {
        apiPage.hitApiDeleteNewData();
    }
}
