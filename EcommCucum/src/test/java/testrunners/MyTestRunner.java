package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/AppFeatures"},
		//features = {"src/test/resources/AppFeatures"},
		glue = {"stepdefinations","AppHooks"},
		//tags = "@Smoke",
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"},
		publish = true
		)

public class MyTestRunner {
	
	

}
//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"