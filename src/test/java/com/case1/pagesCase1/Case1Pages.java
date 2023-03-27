package com.case1.pagesCase1;

import io.cucumber.java.zh_cn.假如;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

public class Case1Pages {
    public Case1Pages(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='header-middle']//a[contains(text(),'Home')]")
    WebElement homeButton;

    @FindBy(xpath = "//div[@class='header-middle']//a[contains(text(),'Signup')]")
    WebElement signupButtonLogin;

    @FindBy(xpath = "//div[@class = 'signup-form']//h2")
    WebElement newUserSignupButton;

    @FindBy(xpath = "//div[@class = 'signup-form']//input[@name='name']")
    WebElement name;

    @FindBy(xpath = "//div[@class = 'signup-form']//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//div[@class = 'signup-form']//button[@type='submit']")
    WebElement signupButton;

    @FindBy(xpath = "//h2[.='Enter Account Information']")
    WebElement enterAcctInfoValidation;

    @FindBy(css = "#id_gender1")
    WebElement mrBox;

    @FindBy(css = "#password")
    WebElement password;

    @FindBy(css = "#days")
    WebElement days;

    @FindBy(css = "#months")
    WebElement months;

    @FindBy(css = "#years")
    WebElement years;

    @FindBy(css = "#newsletter")
    WebElement newsletterCheckBox;

    @FindBy(css = "#optin")
    WebElement offersCheckBox;

    @FindBy(css = "#first_name")
    WebElement fistName;

    @FindBy(css = "#last_name")
    WebElement lastName;

    @FindBy(css = "#company")
    WebElement company;

    @FindBy(css = "#address1")
    WebElement address1;

    @FindBy(css = "#address2")
    WebElement address2;

    @FindBy(css = "#country")
    WebElement country;

    @FindBy(css = "#state")
    WebElement state;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#zipcode")
    WebElement zipcode;

    @FindBy(css = "#mobile_number")
    WebElement mobileNumber;

    @FindBy(xpath = "//button[.='Create Account']")
    WebElement createAccountButton;

    @FindBy(xpath = "//b[.='Account Created!']")
    WebElement createdAccountValidation;

    @FindBy(linkText = "Continue")
    WebElement continueButton;

    @FindBy(xpath = "//a[contains(text(),'Logged in as ')]")
    WebElement loggedInAsUsernameButton;

    @FindBy(xpath= "//div[@class = 'col-sm-8']//a[contains(text(),'Delete Account')]")
    WebElement deleteAcctButton;

    @FindBy(xpath = "//h2[@data-qa='account-deleted']")
    WebElement deletedAcctHeader;

    public void homePageVerificationAndSignUpClick() {
        if (homeButton.isDisplayed()) {
            signupButtonLogin.click();
        }
    }

    public void newUserSignup(String name, String email) {
        if (newUserSignupButton.isDisplayed()) {
            this.name.sendKeys(name);
            this.email.sendKeys(email);
            signupButton.click();
        }
    }

    public String registrationPageHeaderValidation() {
        return BrowserUtils.getText(enterAcctInfoValidation);
    }

    public void enterAccountInfo(String password, String days, String months, String years) {
        mrBox.click();
        this.password.sendKeys(password);
        BrowserUtils.selectBy(this.days, "value", days);
        BrowserUtils.selectBy(this.months, "value", months);
        BrowserUtils.selectBy(this.years, "value", years);
    }

    public void newsAndOffersSignUp() {
        newsletterCheckBox.click();
        offersCheckBox.click();
    }

    public void enterAddressInfo(String firstName, String lastName, String company,
                                 String address1, String address2, String country,
                                 String state, String city, String zipcode, String mobileNumber) {
        this.fistName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.company.sendKeys(company);
        this.address1.sendKeys(address1);
        this.address2.sendKeys(address2);
        BrowserUtils.selectBy(this.country, "value", country);
        this.state.sendKeys(state);
        this.city.sendKeys(city);
        this.zipcode.sendKeys(zipcode);
        this.zipcode.sendKeys(zipcode);
        this.mobileNumber.sendKeys(mobileNumber);
    }

    public void createAccountButton(String createdAccountHeader) {
        createAccountButton.click();
        Assert.assertEquals(createdAccountHeader, BrowserUtils.getText(createdAccountValidation));
    }

    public String continueButtonFunc() {
        continueButton.click();
        String loggedUsername = BrowserUtils.getText(loggedInAsUsernameButton);
        return loggedUsername.substring(loggedUsername.lastIndexOf(" ") + 1);

    }

    public void deleteAcct() {
        deleteAcctButton.click();
    }

    public String deletedAcctValidation() {
        return BrowserUtils.getText(deletedAcctHeader);
    }

}
