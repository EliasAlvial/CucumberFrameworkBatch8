$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/searchEmployee.feature");
formatter.feature({
  "name": "searching for 5",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "searching for 5 sets of id",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@searchingById"
    }
  ]
});
formatter.step({
  "name": "enter \"\u003cId\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "click on search Btn",
  "keyword": "Then "
});
formatter.step({
  "name": "verify \"\u003cId\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Id"
      ]
    },
    {
      "cells": [
        "12115"
      ]
    },
    {
      "cells": [
        "12178"
      ]
    },
    {
      "cells": [
        "12185"
      ]
    },
    {
      "cells": [
        "11830"
      ]
    },
    {
      "cells": [
        "11832"
      ]
    }
  ]
});
formatter.background({
  "name": "When enter valid credentials",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "enter valid credentials",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.LoginStepDefinition.enter_valid_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.LoginStepDefinition.click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify dashboard is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.LoginStepDefinition.verify_dashboard_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on PIM",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.AddEmployeeDefinitions.click_on_PIM()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Employee List",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.SearchEmployeeDefinitions.click_on_Employee_List()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "searching for 5 sets of id",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@searchingById"
    }
  ]
});
formatter.step({
  "name": "enter \"12115\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.SearchEmployeeDefinitions.enter(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on search Btn",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.SearchEmployeeDefinitions.click_on_search_Btn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify \"12115\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.stepdefinitions.SearchEmployeeDefinitions.verify(java.lang.String)"
});
