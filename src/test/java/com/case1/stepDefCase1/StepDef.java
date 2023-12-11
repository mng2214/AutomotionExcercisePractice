package com.case1.stepDefCase1;

import com.case1.pagesCase1.Case1Pages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class StepDef {
    WebDriver driver = DriverHelper.getDriver();
    Case1Pages case1Pages = new Case1Pages(driver);

    @When("User verifies home page is visible before clicks on SightUp Login page")
    public void userVerifiesMainPageIsVisibleBeforeClicksOnSightUpLoginPage() {
        case1Pages.homePageVerificationAndSignUpClick();
    }

    @When("User validates User SignUp is visible then provides {string} and {string} and clicks SignUp")
    public void user_validates_user_sign_up_is_visible_then_provides_and_and_clicks_sign_up(String name, String email) {
        case1Pages.newUserSignup(name, email);
    }

    @When("User verifies {string} is visible")
    public void user_verifies_is_visible(String headerText) {
        Assert.assertEquals(headerText, case1Pages.registrationPageHeaderValidation());
    }

    @And("User fills {string} {string},{string} ,{string}")
    public void userFillsPass(String password, String day, String month, String year) {
        case1Pages.enterAccountInfo(password, day, month, year);
    }

    @When("select Sign up for our newsletter and Receive special offers from our partners!")
    public void select_sign_up_for_our_newsletter_and_receive_special_offers_from_our_partners() {
        case1Pages.newsAndOffersSignUp();
    }

    @When("User fills all personal info  {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string},{string}")
    public void user_fills_all_personal_info(String firstName, String lastName, String company,
                                             String address1, String address2, String country,
                                             String state, String city, String zip, String mobileNumber) {
        case1Pages.enterAddressInfo(firstName, lastName, company, address1, address2, country, state, city, zip, mobileNumber);
    }

    @When("User clicks Create Account button and verifies that {string}")
    public void user_clicks_create_account_button_and_verifies_that(String createdAccountValidation) {
        case1Pages.createAccountButton(createdAccountValidation);
    }

    @And("User Click Continue button before Verify that Logged in as {string} is visible")
    public void userClickContinueButtonBeforeVerifyThatLoggedInAsArturIsVisible(String  username) {
      Assert.assertEquals(username,case1Pages.continueButtonFunc());
    }

    @When("Click Delete Account button")
    public void click_delete_account_button() {
        case1Pages.deleteAcct();
    }

    @Then("Verify that {string} is visible and click Continue button")
    public void verify_that_is_visible_and_click_continue_mbutton(String deletedAcctValidationHeader) {
        Assert.assertEquals(deletedAcctValidationHeader,case1Pages.deletedAcctValidation());
    }


}
