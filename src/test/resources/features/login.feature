@FeatureTag @Login #feature level tag
Feature: Login Functionality
  @validCredentials #sceranio level tag
    Scenario: Login with valid credentials
      #Given navigate to HRMS login page
      When enter valid credentials
      And click on login button
      Then verify dashboard is displayed
      #And quit the browser
  @smoke  @invalidCreds @syntax #adding multiple scenario level tags
    Scenario: Login with invalid credentials
     # Given navigate to HRMS login page
      When enter invalid credentials
      And click on login button
      Then verify error message
      #And quit the browser


    Scenario: Login with Empty username
      Given navigate to HRMS login page
      When enter empty username
      And click on login button
      Then verify empty username error message
      And quit the browser

    Scenario: Login with Empty password
      Given navigate to HRMS login page
      Then enter empty password
      And click on login button
      Then verify empty password error message
      And quit the browser