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
	
	@Given("Open Yocket website")
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
			System.out.println("--> User reached to yocket website");
		} else {
			System.out.println("--> Incorrect website title");
		}
	}

	@And("Select College Finder option")
	public void Select_College_Finder_option() throws InterruptedException{
	   //Select College finder option
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Driver.findElement(By.xpath("//div//ul//li//a[@id='college-finder']")).click();
		System.out.println("--> User navigated to Unviersity/College Finder webpage");
		Thread.sleep(2000);
	}

	@And("Select Masters on Unviversity College finder webpage")
	public void Select_Masters_on_Unviversity_College_finder_webpage() throws InterruptedException {
	    // User is U/c finder page & opts for Masters
		System.out.println("Inside step - User is on university-college finder webpage");
		
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Driver.findElement(By.xpath("//button[contains(text(),'Masters')]")).click();
		
		System.out.println("--> User selects masters");
		
		Thread.sleep(2000);
	}
	
	public void jsClick(WebElement webElement) {
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("arguments[0].click();", webElement);
	}
	
	@And("User fills Step1 details and moves ahead")
	public void User_fills_Step1_details_and_moves_ahead() throws InterruptedException {
		//User fills Step-1 details & clicks next button
		System.out.println("--> User is on Step-1 webpage");
		
		Thread.sleep(3000);
		System.out.println("Where do you want to study? - Select country");	//Validate study country dropdown is displayed
		Driver.findElement(By.xpath("//div//input[@placeholder='Select Country']")).click(); //locating study country dropdown
		System.out.println("--> Study Country list is displayed");

		Thread.sleep(3000);
		
		//Selecting Australia & NewZealand country to study further
		WebElement country_option_Aus_NZ = Driver.findElement(By.xpath("//span[text()='Canada']")); //Australia & New Zealand
		jsClick(country_option_Aus_NZ);
		System.out.println("--> Selected 'Canada' country for further studies");
		
		//Getting no. of frames available
		int size = Driver.findElements(By.id("siqiframe")).size();
		System.out.println("Frame size is "+size);

		//switching to chatbot window
		Driver.switchTo().frame("siqiframe"); 
		System.out.println("--> Switched to chatbot window");

		//Closing chatbot window
		Driver.findElement(By.xpath("//body//div[@documentclick='min_iframe']//self::*")).click();
		System.out.println("--> Closed chatbot window");

		//switching back to main content from chatbot window
		Driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		//Selecting major field to study further
		Driver.findElement(By.xpath("//div//input[@placeholder='Select Major']")).click();
		System.out.println("--> Selected major study dropdown");
		
		Thread.sleep(2000);
		//search major subject as computer science
		Driver.findElement(By.xpath("//div//input[@placeholder='Select Major']")).sendKeys("Computer Science");
		System.out.println("--> Entered Major input");
		
		Thread.sleep(2000);
		//Select computer science from dropdown list
		WebElement study_major = Driver.findElement(By.xpath("//span//div//ul//li[contains(text(),'Computer Science')]")); 
		jsClick(study_major);
		System.out.println("--> User selected major input from lits displayed");
			
		Thread.sleep(2000);
		//Click on next button for step-2
		Driver.findElement(By.xpath("//button[@type='submit' and (contains(text(),'Next'))]")).click(); ////div//button[@type='submit']
		System.out.println("--> User clicked on Next button");	
		
	}
	
	@And("User fills step2 details and clicks next button")
	public void User_fills_step2_details_and_clicks_next_button() throws InterruptedException {
		
		System.out.println("User is on Step-2 page");
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Select undergraduate college from list
		System.out.println("What was your undergraduate college name? - select college");
		Driver.findElement(By.xpath("//div//input[@placeholder='Select College']")).click(); //University college finder search box
		System.out.println("--> Cursor is inside undergraduate college search box");
		
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//div//input[@placeholder='Select College']")).sendKeys("University of Mumbai");
		System.out.println("--> Entered university name input");
		
		Thread.sleep(3000);
		//Select University of Mumbao from dropdown list
		WebElement study_major = Driver.findElement(By.xpath("//span//div//ul//li[contains(text(),'University of Mumbai')]")); 
		jsClick(study_major);
		System.out.println("--> User entered university input from list displayed");
		
		//Course majored in undergraduate
		System.out.println("Which course did you major in?  - select course");
		Driver.findElement(By.xpath("//div//input[@placeholder='Select Major']")).click(); //University college finder search box
		System.out.println("--> Cursor is inside undergraduate college search box");
		
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//div//input[@placeholder='Select Major']")).sendKeys("Computer Science");
		System.out.println("--> Entered university name input");
		
		Thread.sleep(3000);
		//Select Computer Science from dropdown list
		WebElement study_ug_major = Driver.findElement(By.xpath("//span//div//ul//li[contains(text(),'Computer Science')]")); 
		jsClick(study_ug_major);
		System.out.println("--> User entered university input from list displayed");
		
		//Enter Marks for undergrad
		Driver.findElement(By.xpath("//div//input[@id='marks']")).sendKeys("7");
		System.out.println("--> Marke entered for undergrad");
		
		Thread.sleep(2000);
		//Click on next button for step-2
		Driver.findElement(By.xpath("//button[@type='submit' and (contains(text(),'Next'))]")).click();
		System.out.println("--> User clicked on Next button");
	}
	
	@And("User fills step3 details and proceeds further")
	public void User_fills_step3_details_and_proceeds_further() throws InterruptedException {
		
		//Validate english test is displayed		
		System.out.println("Which English test did you take? ");	
		Driver.findElement(By.xpath("//div[@class='text-sm' and contains(text(),'IELTS')]")).click();
		System.out.println("--> English test selected");
		Driver.findElement(By.xpath("//div//span//input[@id='ielts_overall_score']")).sendKeys("6");
		System.out.println("---> IELTS score sent");
		
		Thread.sleep(2000);
		
		//validate aptitude test is displayed
		System.out.println("Which aptitude test did you take?");
		Driver.findElement(By.xpath("(//div[@class='text-sm text-orange-400' or contains(text(),'GMAT')])[2]")).click();
		System.out.println("--> Aptitude test selected");
		Driver.findElement(By.xpath("//div//span//input[@id='total_gmat_score']")).sendKeys("451");
		System.out.println("---> GMAT score sent");
		
		Thread.sleep(2000);
		//Click on next button for step-2
		Driver.findElement(By.xpath("//button[@type='submit' and (contains(text(),'Next'))]")).click();
		System.out.println("--> User clicked on Next button");
	}

	@And("User fills step4 details and finds list of universities")
	public void User_fills_step4_details_and_finds_list_of_universities() throws InterruptedException {
		
		Thread.sleep(2000);
		//Validate english test is displayed		
		System.out.println("How much relevant work experience do you have?");	
		Driver.findElement(By.xpath("//div//input[@id='work_exp' or name='work_exp']")).click();
		System.out.println("--> Work Experience selected");
		Driver.findElement(By.xpath("//div//input[@id='work_exp' or name='work_exp']")).sendKeys("44");
		System.out.println("---> Work experience entered");

		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//validate research paper is displayed
		System.out.println("Have you published any relevant research papers?");
		System.out.println("--> leaving it unselected");
		
		//leaving research papers as blank & proceeding further
		System.out.println("How many relevant projects have you done?");
		Driver.findElement(By.xpath("//input[@id='project']")).click();
		System.out.println("--> Research paper fieled left blank");

		Thread.sleep(2000);
		//Click on next button for step-2
		Driver.findElement(By.xpath("//button[@type='submit' and (contains(text(),'Find Universities'))]")).click();
		System.out.println("--> User clicked on Find Universities button");
	}
	@Then("List of universities is displayed to user")
	public void List_of_universities_is_displayed_to_user() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    Thread.sleep(10);
	    
	    if(Driver.getTitle().equalsIgnoreCase("Masters (MS) University Finder: Find the Best Suited Colleges & Universities to Study MS Abroad | Yocket")) {
	    	System.out.println("--> List of universities displayed");
	    } else {
	    	System.out.println("Uh-oh! That spell didn’t work");
	    }
	    Driver.close();
	    
	}
}
