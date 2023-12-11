package com.case1.stepDefCase1;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class HookClass {
    WebDriver driver = DriverHelper.getDriver();

    @Before
    public void setup() {
       driver.get(ConfigReader.readProperty("automationExercise"));
       //driver.get("http://automationexercise.com");

    }

    @After
    public void tearDown(Scenario scenario) {
        BrowserUtils.getScreenShotForCucumber(driver, scenario);
        driver.quit();
    }
}
