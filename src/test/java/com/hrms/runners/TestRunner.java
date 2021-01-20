package com.hrms.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
//need to give a path for our feature files and
// glue our step definitions - implementation
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/",
                    glue = "com/hrms/stepdefinitions",
        //dry run will look ahead if there's any unimplemented steps
//in your console it will give you the method that is not implemented
//it's not gonna run the feature file al all if it sees the unimplemented methods
//when set as true will run over teh feature steps and reveal unimplemented steps in console
//when set to true but there are no unimplemented steps it will not run tests at all

                    dryRun = false,// when set as true, will run over the features steps and reveal unimplemented
                    tags = { "@parameter" },
                    strict = false,
                    plugin = {"pretty",// will print executed steps inside console
                            "html:target/cucumber-default-reports", // generate default html report
                           "rerun:target/FailedTests.txt",
                            "json:target/cucumber.json"
}


)
public class TestRunner {

}
