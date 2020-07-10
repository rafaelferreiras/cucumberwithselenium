package runner_files;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/featureFiles",glue = "step_definition")

public class RunTestNGTest extends AbstractTestNGCucumberTests {

}
