package com.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramworkTesting {

    static WebDriver driver;

    @Given("User on the Google page")
    public void userOnTheGooglePage() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @Then("title is {string}")
    public void titleIs(String expectedTitle) {

        String actualTitle=driver.getTitle();
        Assert.assertEquals("Not equal", actualTitle,expectedTitle);

    }
}
