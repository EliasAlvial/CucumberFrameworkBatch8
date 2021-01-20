package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition extends CommonMethods {
    @Given("navigate to HRMS login page")
    public void navigate_to_hrms_login_page() {
    setUp();
    }

    @When("enter valid credentials")
    public void enter_valid_credentials() {
    loginPage.login("Admin","Hum@nhrm123");
    }

    @When("click on login button")
    public void click_on_login_button() {
    loginPage.clickOnLoginBtn();
    }

    @Then("verify dashboard is displayed")
    public void verify_dashboard_is_displayed() {
        Assert.assertTrue(dashBoardPage.welcomeMessage.isDisplayed());
    }

    @And("quit the browser")
    public void quitTheBrowser() {
        tearDown();
    }

    @When("enter invalid credentials")
    public void enter_invalid_credentials() {
      loginPage.login("invalid", "invalid");
    }

    @Then("verify error message")
    public void verify_error_message() {
        Assert.assertEquals("Verifying error message", "Invalid credentials",loginPage.getErrorMessageText());
    }
    @Then("verify empty username error message")
    public void verify_empty_username_error_message() {
       Assert.assertEquals("Verifying no username error message", "Username cannot be empty", loginPage.getErrorMessageText());
    }

    @Then("verify empty password error message")
    public void verify_empty_password_error_message() {
      Assert.assertEquals("Verifying no password error message", "Password cannot be empty",loginPage.getErrorMessageText());
    }

    @When("enter empty username")
    public void enterEmptyUsername() {
        loginPage.login("","Hum@nhrm123");
    }

    @Then("enter empty password")
    public void enterEmptyPassword() {
        loginPage.login("admin", "");
    }

}
