package eledgerapi.cucumber;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/feature"
//, tags = "@get_list_of_reports_users_not_exist"
)
public class EledgerApiRunnerTest {
}
