Feature: Google Search feature
 @searchWithEnter
  Scenario: search by typing and hitting enter
   Given user navigated to google application
    When user enters text
    And hit enter
    Then results is displayed
  @searchWithGoogleSearchButton
   Scenario: search by typing and using google search button
     Given user navigated to google application
     When user enters text
     And click on google search button
     Then results is displayed