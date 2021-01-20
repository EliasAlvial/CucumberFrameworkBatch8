Feature: Add Employee Functionality

  Background:
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
    When click on PIM
    And click on add employee button


    @addEmployeeWithoutLogin
    Scenario: Add employee without login details

      Then enter first and last name
      And click on save button
      Then verify employee is added successfully

      @addEmployeeWithLogin
      Scenario: Add employee with login credentials and with middle
        Then enter first and last name and middle name
        When click on login details checkbox
        Then enter login details
        And click on save button
        Then verify employee is added successfully

        @parameter
    Scenario: Add employee without login details but with middle name
      Then enter first name "John", middle name "Jacob" and last name "Jingleheimer-Schmidt"
      #parameterized
      And click on save button
      Then verify that "John Jacob Jingleheimer-Schmidt" is added successfully