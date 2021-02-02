package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

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

    @When("enter {string}, {string} and {string}")
    public void enter_and(String firstName, String middleName, String lastName) {
        addEmployeePage.sendFirstNMiddleNameNLastName(firstName,middleName, lastName);
    }


    @Then("verify {string}, {string} and {string} is added successfully")
    public void verify_and_is_added_successfully(String firstName, String middleName, String lastName) {
       String fullName=firstName+" "+middleName+" "+lastName;
       String actualProfileName= personalDetailPage.getUserProfileName();
       Assert.assertEquals("Verifying profile name", fullName,actualProfileName);
    }

    @When("add multiple employees and verify they are added successfully")
    public void add_multiple_employees_and_verify_they_are_added_successfully(DataTable employees) {
      List<Map<String, String>> employeeNames=employees.asMaps();

      for(Map<String, String> employeeName:employeeNames){
          String firstName= employeeName.get("FirstName");
          String middleName= employeeName.get("MiddleName");
          String lastName= employeeName.get("LastName");
          String employeeId = employeeName.get("EmployeeID");

          addEmployeePage.sendFirstNMiddleNameNLastName(firstName, middleName, lastName);
          addEmployeePage.enterEmployeeId(employeeId);
          addEmployeePage.clickOnSaveBtn();

          String actualFullName= personalDetailPage.getUserProfileName();
          String expectedFullName=firstName+" "+middleName+" "+lastName;
          Assert.assertEquals("Verifying profile name",expectedFullName, actualFullName);
          dashBoardPage.clickOnEmployeeListBtn();

        }
    }
    @When("add multiple employees from excel {string} sheet and verify they are added")
    public void add_multiple_employees_from_excel_sheet_and_verify_they_are_added(String sheetName) {
        List<Map<String,String>> excelData=ExcelUtils.excelIntoListMap(Constants.TESTDATA_FILEPATH, sheetName);

        for (Map<String, String>excelEmpNAme:excelData){
            String firstName=excelEmpNAme.get("FirstName");
            String middleName=excelEmpNAme.get("MiddleName");
            String lastName=excelEmpNAme.get("LastName");
            String employeeID=excelEmpNAme.get("EmployeeID");

            addEmployeePage.sendFirstNMiddleNameNLastName(firstName, middleName, lastName);
            addEmployeePage.enterEmployeeId(employeeID);
            addEmployeePage.clickOnSaveBtn();

            String actualFullName= personalDetailPage.getUserProfileName();
            String expectedFullName=firstName+" "+middleName+" "+lastName;
            Assert.assertEquals("Verifying profile name",expectedFullName, actualFullName);
            dashBoardPage.clickOnEmployeeListBtn();


        }
    }

}
