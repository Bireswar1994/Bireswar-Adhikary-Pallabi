package CucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/resources/FinalFeature/Amazon.feature",monochrome=true,
glue="StepDefinitions",tags="")
public class TestNgRunner extends AbstractTestNGCucumberTests {

}
