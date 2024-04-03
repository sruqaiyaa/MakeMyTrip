package Runner;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "Features" ,
glue = "Stepdefinition")
public class RunnerClass extends AbstractTestNGCucumberTests{

}