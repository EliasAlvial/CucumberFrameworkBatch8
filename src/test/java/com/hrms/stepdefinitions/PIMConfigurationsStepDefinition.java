package com.hrms.stepdefinitions;

import com.hrms.utils.CommonMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class PIMConfigurationsStepDefinition extends CommonMethods {
    @When("click on configuration dopdown")
    public void click_on_configuration_dopdown() {
    pimConfigurationPage.clickOnConfigDropDown();
    }

    @When("clock on optional fields")
    public void clock_on_optional_fields() {
    pimConfigurationPage.clickOnOptionalFields();
    }
    @Then("click on edit button")
    public void click_on_edit_button() {
        pimConfigurationPage.clickOnEditButton();
    }
    @Then("uncheck unnecessary checkboxes")
    public void uncheck_unnecessary_checkboxes(DataTable checkBoxOptions) {
    List<String> expectedCheckBoxTextOptions=checkBoxOptions.asList();
        for (int i = 0; i < expectedCheckBoxTextOptions.size(); i++) {
            clickRadioOnCheckBoxByText(pimConfigurationPage.checkBoxes, expectedCheckBoxTextOptions.get(i));
        }

    }

}
