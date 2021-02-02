package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends CommonMethods {
@FindBy(xpath = "//input[@name='q']")
    public WebElement searchBox;

//@FindBy()
}
