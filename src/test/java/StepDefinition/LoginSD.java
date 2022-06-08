package StepDefinition;

import Helper.Check;
import Pages.automation.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSD  {

    @Given("^I launch automationpractice website$")
    public void launchHotels() {
        UseDriver.openUrl("http://automationpractice.com/");
    }

    LoginPage lp = new LoginPage();
    @When("^I click the 'Sign in' button in the automationpractice launch page$")
    public void clickSignInInHotelPage(){
        lp.clickSignInButton();
    }

    @And("^I enter '(.+)' as valid login email in the SignIn page$")
    public void enterValidEmailAddressInSignIn(String inputEmail) {
        lp.enterLoginEmailAddress(inputEmail);

    }

    @And("^I enter '(.+)' as valid login password in the SignIn page$")
    public void enterValidEmailPasswordInSignIn(String inputPassword) {
        lp.enterLoginPassword(inputPassword);

    }

    @And("^I select the 'Sign in' button in the automationpractice page$")
    public void clickLoginSignInButton() {
        lp.clickSignInLoginButton();

    }

    @Then("^I verify the title  in the automationpractice homepage$")
    public void verifyHomePageTitle() {
        String validPageTitle="My account - My Store";
        String pageTitle=lp.getWebPageTitle();
        Check.checkEquals(pageTitle, validPageTitle,"Invalid page title is displayed");
    }
    @When("I enter {string} as invalid login email in the SignIn page")
    public void enterInvalidEmailAddressInSignIn(String LoginEmail) {
        lp.enterLoginEmailAddress(LoginEmail);
    }

    @When("I enter {string} as invalid login password in the SignIn page")
    public void enterInvalidLPasswordInSignIn(String LoginPassword) {
        lp.enterLoginEmailAddress(LoginPassword);
    }
    @Then("I verify the display of login failed error message in the login page")
    public void invalidLoginErrorMessageDisplay() {
            boolean loginFailErrorMessage=lp.loginFailErrorMessage();
    }
}
