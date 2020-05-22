package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features={"FeatureFiles"},tags={"@scenariowithDatatable"},glue={"stepDefinations"},
plugin={"com.cucumber.listener.ExtentCucumberFormatter:Reports/report.html","pretty", 
"html:target/cucumber-reports"},monochrome=true)
public class Runner1 extends AbstractTestNGCucumberTests{

}
