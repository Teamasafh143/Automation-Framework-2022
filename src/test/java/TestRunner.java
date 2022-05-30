
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        // Path to feature files
        features = {"src/test/resources/YourLogo"},

        // Specify the step definition package name
        glue = {"StepDefinition", "Web"},

        // This create a default Cucumber report
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/Cucumber.json"
        }
)
public class TestRunner {
}