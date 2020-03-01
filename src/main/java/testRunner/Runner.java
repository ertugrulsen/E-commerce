package testRunner;
import org.junit.Before;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

import java.lang.management.ManagementFactory;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        features = {"src/test/java/features"},
        monochrome = true,
        glue = { "step_definitions" })
public class Runner {

}




