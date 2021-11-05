package TestSuiteRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "./src/Features",
		glue= {"stepDefinitions"},
		dryRun=false,
		monochrome=true,
		format= {"pretty","html:test_output"}
		)
public class TestRunner {

}
