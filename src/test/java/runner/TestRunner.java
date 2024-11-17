package runner;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "src/test/java/stepDefinition",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html", // Genera un reporte HTML
                "json:target/cucumber-reports/cucumber.json" // Genera un reporte JSON
        }
)
public class TestRunner {
}
