package com.hrms.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchDefinitions {

    WebDriver driver=new ChromeDriver();
    @Given("user navigated to google application")
    public void user_navigated_to_google_application() {
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.google.com/?safe=active&ssui=on");
    }

    @When("user enters text")
    public void user_enters_text() {
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Maven Repository");
    }
    @When("hit enter")
    public void hit_enter() {
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);

    }
    @Then("results is displayed")
    public void results_is_displayed() {
    Boolean isDisplayed=driver.findElement(By.xpath("//a[@href='https://mvnrepository.com/']")).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }
    @When("click on google search button")
    public void click_on_google_search_button() {
       driver.findElement(By.name("btnK")).click();
    }
}
