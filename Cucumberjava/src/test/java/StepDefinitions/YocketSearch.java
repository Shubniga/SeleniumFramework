package StepDefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class YocketSearch {

	WebDriver Driver = null;
	
	@Given("Oepn Yocket website")
	public void Oepn_Yocket_website() {
	    
	    System.out.println("User visits to Yocket.com website");
	    
	    String projectPath = System.getProperty("user.dir"); 
	    System.out.println("Project path is :"+projectPath); //to validate the project path
	    
	    System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe"); //initial path is similar to projectpath hence appended with variable
	    Driver = new ChromeDriver();
	    
	    Driver.manage().window().maximize(); //maximize window size
	    Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Implicitlywait is deprecated in selenium4 hence used this another workaround
	    
		Driver.get("https://yocket.com/"); //navigating to google webpage
		if(Driver.getTitle().equalsIgnoreCase("Yocket: Overseas Education Consultants to Assist You in Your Higher Education Abroad | Yocket")) {
			System.out.println("User reached to yocket website");
		} else {
			System.out.println("Incorrect website title");
		}
	}

	@And("Select College Finder option")
	public void Select_College_Finder_option() throws InterruptedException{
	   //Select College finder option
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Driver.findElement(By.xpath("//div//ul//li//a[@id='college-finder']")).click();
		System.out.println("User navigated to Unviersity/College Finder webpage");
		Thread.sleep(2000);
	}

	@And("Select Masters on Unviversity College finder webpage")
	public void Select_Masters_on_Unviversity_College_finder_webpage() throws InterruptedException {
	    // User is U/c finder page & opts for Masters
		System.out.println("Inside step - User is on university-college finder webpage");
		
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Driver.findElement(By.xpath("//button[contains(text(),'Masters')]")).click();
		
		System.out.println("User selects masters");
		
		Thread.sleep(2000);
	}
	
	public void jsClick(WebElement webElement) {
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("arguments[0].click();", webElement);
	}
	
	@And("User fills Step1 details and moves ahead")
	public void User_fills_Step1_details_and_moves_ahead() throws InterruptedException {
		//User fills Step-1 details & clicks next button
		System.out.println("User is on Step-1 webpage");
		
		Thread.sleep(3000);
		System.out.println("Where do you want to study? - Select country");	//Validate study country dropdown is displayed
		Driver.findElement(By.xpath("//div//input[@placeholder='Select Country']")).click(); //locating study country dropdown
		System.out.println("Study Country list is displayed");

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Selecting Australia & NewZealand country to study further
		WebElement country_option_Aus_NZ = Driver.findElement(By.xpath("//span[text()='Australia & New Zealand']")); 
		jsClick(country_option_Aus_NZ);
		System.out.println("Selected 'Australia & NewZealand' country for further studies");

		Thread.sleep(5000);
		
		Driver.findElement(By.xpath("//div//input[@placeholder='Select Major']")).click();
		System.out.println("Selected major study dropdown");
		
		Thread.sleep(3000);
		//((WebElement) Driver).sendKeys("Computer Science"); //search major subject as computer science
		Driver.findElement(By.xpath("//div//input[@placeholder='Select Major']")).sendKeys("Computer Science");
		System.out.println("Entered Major input");
		
		Thread.sleep(4000);
		WebElement study_major = Driver.findElement(By.xpath("//span//div//ul//li[contains(text(),'Computer Science')]")); //Select computer science from dropdown list
		jsClick(study_major);
		System.out.println("User selected major input from lits displayed");
		
		//Getting no. of frames available
		int size = Driver.findElements(By.id("siqiframe")).size();
		System.out.println("Frame size is "+size);
		
		Driver.switchTo().frame("siqiframe"); //switching to chatbot window
		System.out.println("Switched to chatbot window");
		
		Driver.findElement(By.xpath("//body//div[@documentclick='min_iframe']//self::*")).click();
		System.out.println("Closed chatbot window");
		
		Driver.switchTo().defaultContent(); //switching back to main content from chatbot window
		
		Thread.sleep(3000);
		//Click on next button for step-2
		Driver.findElement(By.xpath("//button[@type='submit' and (contains(text(),'Next'))]")).click(); ////div//button[@type='submit']
		System.out.println("User clicked on Next button");	
		
	}
	
	@And("User fills step2 details and clicks next button")
	public void User_fills_step2_details_and_clicks_next_button() throws InterruptedException {
		
		System.out.println("User is on Step-2 page");
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Select undergraduate college from list
		Driver.findElement(By.xpath("//div//input[@placeholder='Select College']")).click(); //University college finder search box
		System.out.println("User clicked on undergraduate college search box");
	}
	
	@Then("User fills step1 details and moves ahead")
	public void user_fills_step1_details_and_moves_ahead() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		//Validate study country dropdown is displayed		
		System.out.println("Select country to study");	
		Driver.findElement(By.xpath("//div//input[@placeholder='Select Country']")).click();
		System.out.println("Country list displayed");
		
		//Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement country_option_Aus_NZ = Driver.findElement(By.xpath("//span[text()='Australia & New Zealand']")); 
		jsClick(country_option_Aus_NZ);
		System.out.println("Country name selected");
		
		Thread.sleep(3000);
	}

	@Then("User is navigated to step2")
	public void user_is_navigated_to_step2() {
		By Undergrad_collgname_marks = By.id("marks"); //xpath("//input[@id='marks']");
		By Undergrad_collgname_nxtbtn = By.linkText("Next"); //xpath("//button[contains(text(),'Next')]");
	}
	@Then("User fills step2 details and moves ahead")
	public void user_fills_step2_details_and_moves_ahead() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@Then("User is navigated to step3 and moves ahead")
	public void user_is_navigated_to_step3_and_moves_ahead() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@Then("User fills step3 details and moves ahead")
	public void user_fills_step3_details_and_moves_ahead() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@Then("User is navigated to Step4")
	public void user_is_navigated_to_step4() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@Then("User fills step4 details and finds list of universities")
	public void user_fills_step4_details_and_finds_list_of_universities() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
}
