package com.case1.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",//feature files
        glue = "com/case1/stepDefCase1", //step definitions
        dryRun = false,//getting snips without executing
        tags = "@automation",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"}
        //and refers to one scenario
        //or refers to multiple scenarios
)
public class Runner {
}
