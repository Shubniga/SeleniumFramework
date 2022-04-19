package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class YocketSearch {

	WebDriver Driver = null;
	
	@Given("browser is open")
	public void browser_is_open() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Inside step - browser is open");
	    
	    String projectPath = System.getProperty("user.dir"); 
	    System.out.println("Project path is :"+projectPath); //to validate the project path
	    
	    System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe"); //initial path is similar to projectpath hence appended with variable
	    Driver = new ChromeDriver();
	    
	    Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //Implicitlywait is deprecated in selenium4 hence used this another workaround
	    
	}

	@And("user is google search page")
	public void user_is_google_search_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside step - user is on google search page");
		
		Driver.navigate().to("https://www.google.com/"); //navigating to google webpage
	}

	@When("user enters yocket.com as search text")
	public void user_enters_yocket_com_as_search_text() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside step - user enters yocket.com as search text");
		
		Driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("yocket.com");
		Thread.sleep(2000);
	}

	@And("hits enter")
	public void hits_enter() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside step - hits enter");
		
		Driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Then("user is navigated on google search results")
	public void user_is_navigated_on_yocket_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside step - user is navigated on yocket homepage");
		
		if(Driver.getPageSource().contains("Yocket: Overseas Education Consultants to Assist You in Your ...")) {
			System.out.println("Yocket title available");
		} else {
			System.out.println("Incorrect tittle match");
		}
	}
	
	@And("user selects University College Finder")
	public void user_selects_University_College_Finder() throws InterruptedException {
		System.out.println("Inside step - user selects University College Finder");
		
		Driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/table/tbody/tr[2]/td/div/h3/a")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
	}
}
