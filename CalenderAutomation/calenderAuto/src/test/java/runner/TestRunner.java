package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "D:\\FusionSoftware\\Java\\CodePractice\\calenderAuto\\src\\test\\java\\featureFiles",
glue="implementationFiles",
plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
"html:target/report.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
	

}
