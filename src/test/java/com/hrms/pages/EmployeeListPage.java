package com.hrms.pages;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage extends CommonMethods {
   @FindBy(xpath = "//input[@id ='empsearch_employee_name_empName']")
   public WebElement searchEmployeeName;

    @FindBy(id = "empsearch_id")
    public WebElement idEmployee;

    @FindBy(id = "searchBtn")
    public WebElement searchBtn;

    @FindBy(xpath = "//td[@class= 'left']/a")
    public WebElement employeeID;

    @FindBy(xpath = "//table[@id = 'resultTable']/tbody/tr[1]/td[3]")
    public WebElement employeeFirstNMiddleName;

    @FindBy(xpath = "//table[@id ='resultTable']/tbody/tr[1]/td[4]")
    public WebElement employeeLastName;

    public void enterIdNumber(String empId){
        sendText(idEmployee,empId);
    }
    public void clickSearchBtn(){
        jsClick(searchBtn);
    }
    public String employeeIDNumberVerification(){
        return employeeID.getText();
    }

    public void enterEmployeeName(String firstName, String middleName, String lastName){
        String fullName=firstName+" "+middleName+" "+lastName;
        sendText(searchEmployeeName, fullName);
    }
    public String getFirstNMiddleName(){
        return employeeFirstNMiddleName.getText();

    }

    public String getLastName(){
        return employeeLastName.getText();
    }
    public EmployeeListPage() {
        PageFactory.initElements(driver, this);
    }
}
