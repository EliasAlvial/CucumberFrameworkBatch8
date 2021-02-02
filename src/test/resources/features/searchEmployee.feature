Feature: searching for 5

  Background:  When enter valid credentials
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
    Then click on PIM
    Then click on Employee List


  @searchingById
  Scenario Outline:searching for 5 sets of id
    When enter "<Id>"
    Then click on search Btn
    And verify "<Id>"
    Examples:
      | Id    |
      | 12115 |
      | 12178 |
      | 12185 |
      | 11830 |
      | 11832 |

  @searchingByName
  Scenario Outline: searching for 5 sets of data by name
    When enter employee "<firstName>", "<middleName>" and "<lastName>"
    Then click on search Btn
    And verify "<firstName>", "<middleName>" and "<lastName>"
    Examples:
      | firstName | middleName | lastName             |
      | John      | Jacob      | Jingleheimer-Schmidt |
      | John      | J          | Wick                 |
      | Miss      | Mary       | Mack                 |
      | All       | Dressed    | in Black             |
      | Juan      | Luis       | Guerra               |
