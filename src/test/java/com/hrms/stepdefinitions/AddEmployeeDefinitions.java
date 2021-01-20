package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddEmployeeDefinitions extends CommonMethods {

    @When("click on PIM")
    public void click_on_PIM() {
    dashBoardPage.clickOnPIMJS();
    }

    @When("click on add employee button")
    public void click_on_add_employee_button() {
        dashBoardPage.ClickOnAddEmployeeBtn();
    }
    @Then("enter first and last name")
    public void enter_first_and_last_name() {
    addEmployeePage.sendFirstNLastName("Thor", "Vadar");
    }
    @Then("click on save button")
    public void click_on_save_button() {
    addEmployeePage.clickOnSaveBtn();
    }
    @Then("verify employee is added successfully")
    public void verify_employee_is_added_successfully() {
        String actualProfileName=personalDetailPage.getUserProfileName();
        Assert.assertEquals("Verifying profile name", "Thor Vadar", actualProfileName);
    }

    @Then("enter first name {string}, middle name {string} and last name {string}")
    public void enter_first_name_middle_name_and_last_name(String firstName, String middleName,
                                                           String lastName) {
        addEmployeePage.sendFirstNMiddleNameNLastName(firstName, middleName, lastName);
    }


    @Then("verify that {string} is added successfully")
    public void verify_that_is_added_successfully(String fullName) {
        String actualProfileName=personalDetailPage.getUserProfileName();
        Assert.assertEquals("Verifying profile name", fullName, actualProfileName);
    }

}