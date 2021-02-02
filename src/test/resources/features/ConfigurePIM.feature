Feature: Configure PIM - Optional Fields
@PIM
  Scenario: Unchecking unnecessary checkboxes
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
    When click on PIM
    When click on configuration dopdown
    And  clock on optional fields
    Then click on edit button
    And uncheck unnecessary checkboxes
      |Show SSN field in Personal Details|
      |Show SSN field in Personal Details|