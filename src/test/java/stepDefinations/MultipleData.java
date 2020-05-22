package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MultipleData {
	WebDriver driver;
	String url="http://orangehrm.qedgetech.com/";
	@When("^I open OrangeHRMS URL on \"([^\"]*)\"$")
	public void i_open_OrangeHRMS_URL_on(String brw) throws Throwable {
	  if(brw.equalsIgnoreCase("chrome"))  
	  {
		  System.setProperty("webdriver.chrome.driver", "f://chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get(url);
		  driver.manage().window().maximize(); 
	  }
	  else if(brw.equalsIgnoreCase("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver", "f://geckodriver.exe");
		  driver=new FirefoxDriver();
		  driver.get(url);  
	  }
	}

	@When("^I enter \"([^\"]*)\" in usernameField$")
	public void i_enter_in_usernameField(String username) throws Throwable {
	   driver.findElement(By.name("txtUsername")).sendKeys(username); 
	}

	@When("^I enter \"([^\"]*)\" in passwordField$")
	public void i_enter_in_passwordField(String password) throws Throwable {
		driver.findElement(By.name("txtPassword")).sendKeys(password); 
	}

	@When("^clicking Login Button$")
	public void clicking_Login_Button() throws Throwable {
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(5000);
	}

	@Then("^I Should verify dashboard in url$")
	public void i_Should_verify_dashboard_in_url() throws Throwable {
		if(driver.getCurrentUrl().contains("dash"))
	    {
	    	System.out.println("Login success");
	    }
	    else
	    {
	    	System.out.println("Login Fail");
	    }
	}

	@When("^Closingbrowser$")
	public void closingbrowser() throws Throwable {
	    Thread.sleep(5000);
	    driver.close();
	}

}
