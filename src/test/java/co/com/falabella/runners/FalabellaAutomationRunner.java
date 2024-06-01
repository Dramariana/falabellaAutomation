package co.com.falabella.runners;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features", glue = {
        "co.com.falabella.stepdefinitions" }, snippets = CucumberOptions.SnippetType.CAMELCASE)
public class FalabellaAutomationRunner {
}
