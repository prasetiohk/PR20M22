package stepDef;

import pages.WebPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebStep {

    WebPage webPage;
    public WebStep(){
        this.webPage = new WebPage();
    }

    @Given("user is on login page")
    public void userIsOnLoginPage(){
        webPage.isOnLoginPage();
    }

    @And("user click button login")
    public void userClickButtonLogin() {
        webPage.clickButtonLogin();
    }

    @And("user input username {string}")
    public void userInputUsername(String username) {
        webPage.inputUserName(username);
    }

    @And("user input password {string}")
    public void userInputPassword(String password) {
        webPage.inputPassword(password);
    }

    @When("user click button login new")
    public void userClickButtonLoginNew() {
        webPage.clickButtonLoginNew();
    }

    @Then("user is on homepage")
    public void userIsOnHomepage() {
        webPage.isOnHomepage();
    }

    @Then("user able to see popup message {string}")
    public void userAbleToSeePopupMessage(String message) {
    }

    @And("user click button logout")
    public void userClickButtonLogout() {
//        webPage.clickButtonLogout();
    }

}
