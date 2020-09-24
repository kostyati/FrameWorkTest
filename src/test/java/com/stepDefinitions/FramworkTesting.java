package com.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FramworkTesting {


    private static final Logger logger= LogManager.getLogger();
    static WebDriver driver;

    @Given("User on the Google page")
    public void userOnTheGooglePage() throws MalformedURLException {

        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        logger.debug("Test start");
       // driver=new ChromeDriver();
//        ChromeOptions chromeOptions=new ChromeOptions();
//        chromeOptions.setCapability("browserVersion","76");
//        chromeOptions.setCapability("platformName","Ubuntu 20.04.1");
//        WebDriver driver=new RemoteWebDriver(new URL("localhost:8080"), chromeOptions);
        driver.get("https://www.google.com");
        logger.debug("Google page is open");

    }

    @Then("title is {string}")
    public void titleIs(String expectedTitle) {
        logger.debug("verifying title");
        String actualTitle=driver.getTitle();
        Assert.assertEquals("Not equal", actualTitle,expectedTitle);
        logger.debug("Test is finished");
        driver.quit();
    }
}
