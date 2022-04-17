package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(features="src/test/resources/Feature", glue={"StepDefinitions"},
monochrome = true,
plugin= {"pretty", "junit:target/JUnitReports/report.xml", //fetching report in XML form
		"html:target/HtmlReports.html",	//fetching report in HTML form
		"json:target/JSONReports/report.json"} //fetching report in JSON form
		)

public class TestRunner {

}
