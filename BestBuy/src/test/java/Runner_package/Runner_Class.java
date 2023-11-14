package Runner_package;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/java/feature/Choose_Country.feature"},
		//dryRun = true,
		glue = "Step_Def",
		monochrome = true,
		plugin = {"pretty",
				"html:reports",
				"json:reports/result.json",
				"junit:reports/result.xml"}
				
		)
public class Runner_Class  extends AbstractTestNGCucumberTests {

}
