package runnerFiles;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources", 
				 glue = "stepDefinitions", 
				 plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"}
//				 ,tags = {"@login_teste"}
				)

public class RunTestNGTest extends AbstractTestNGCucumberTests {

	  @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
}