package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchEmployeeDefinitions extends CommonMethods {
    @Then("click on Employee List")
    public void click_on_Employee_List() {
      dashBoardPage.clickOnEmployeeListBtn();
    }

    @When("enter {string}")
    public void enter(String empID) {
    employeeListPage.enterIdNumber(empID);
    }
    @Then("click on search Btn")
    public void click_on_search_Btn() {
        employeeListPage.clickSearchBtn();
    }
    @Then("verify {string}")
    public void verify(String empID) {
       String actualEmpID=employeeListPage.employeeIDNumberVerification();
        Assert.assertEquals("Verifying employee ID#", empID, actualEmpID);
    }

    @When("enter employee {string}, {string} and {string}")
    public void enter_employee_and(String firstName, String middleName, String lastName) {
//        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='empsearch_employee_name_empName']")));
//        employeeListPage.searchEmployeeName.click();
//       employeeListPage.enterEmployeeName(firstName, middleName, lastName);
//        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id ='empsearch_employee_name_empName']")));
//        employeeListPage.searchEmployeeName.click();
        sendText(employeeListPage.searchEmployeeName,firstName+" "+middleName+" "+lastName);
    }

    @Then("verify {string}, {string} and {string}")
    public void verify_and(String firstName, String middleName, String lastName) {
        String expectedFirstNameNMiddleName=firstName+" "+middleName;
        String expectedLastName=lastName;
        String actualFirstNMiddleName=employeeListPage.getFirstNMiddleName();
        String actualLastName= employeeListPage.getLastName();
        Assert.assertEquals("verifying first and  middle name", expectedFirstNameNMiddleName,actualFirstNMiddleName);
        Assert.assertEquals("verifying last name", expectedLastName,actualLastName);
    }

}
