package com.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramworkTesting {


    private static final Logger logger= LogManager.getLogger();
    static WebDriver driver;

    @Given("User on the Google page")
    public void userOnTheGooglePage() {

        WebDriverManager.chromedriver().setup();
        logger.debug("Test start");
        driver=new ChromeDriver();
        driver.get("https://www.google.com");
        logger.debug("Google page is open");

    }

    @Then("title is {string}")
    public void titleIs(String expectedTitle) {
        logger.debug("verifying title");
        String actualTitle=driver.getTitle();
        Assert.assertEquals("Not equal", actualTitle,expectedTitle);
        logger.debug("Test is finished");
    }
}
