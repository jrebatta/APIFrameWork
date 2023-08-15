package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        strict = true,
        tags = "@TEST02",
        glue = "tests",
        monochrome = true
)
public class Runner {

}
