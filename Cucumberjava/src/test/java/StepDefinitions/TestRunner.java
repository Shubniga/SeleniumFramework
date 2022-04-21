package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(features="src/test/resources/Feature", glue={"StepDefinitions"},
monochrome = true,
plugin= {"pretty", "junit:target/JUnitReport/junitreport.xml", //fetching report in XML form
		"html:target/HtmlReport/HtmlReport.html",	//fetching report in HTML form
		"json:target/JSONReport/jsonreport.json"} //fetching report in JSON form
		)

public class TestRunner {

}
