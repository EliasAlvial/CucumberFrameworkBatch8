package com.hrms.pages;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods {
    @FindBy(id="firstName")
    public WebElement firstNameTextBox;

    @FindBy(id="middleName")
    public WebElement middleNameTextBox;

    @FindBy (id="lastName")
    public WebElement lastNameTextBox;

    @FindBy(id="employeeId")
    public WebElement empIdTextBox;

    @FindBy(id="btnSave")
    public WebElement saveButton;

    @FindBy(id="chkLogin")
    public WebElement createLoginCheckBox;

    @FindBy (id = "photofile")
    public WebElement photograph;

    @FindBy (id = "chkLogin")
    public WebElement createLoginDetails;

    @FindBy (id = "user_name")
    public WebElement usernameCreate;

    @FindBy (id = "user_password")
    public WebElement userPassword;

    @FindBy (id = "re_password")
    public WebElement rePassword;

    public void sendFirstNLastName(String FirstName, String LastName){
        sendText(firstNameTextBox, FirstName);
        sendText(lastNameTextBox, LastName);
    }
    public void sendFirstNMiddleNameNLastName(String firstName, String middleName,String lastName){
        sendText(firstNameTextBox, firstName);
        sendText(middleNameTextBox, middleName);
        sendText(lastNameTextBox, lastName);
    }
    public void clickOnSaveBtn(){
        jsClick(saveButton);
    }

    public AddEmployeePage(){
        PageFactory.initElements(driver, this);
    }
}
