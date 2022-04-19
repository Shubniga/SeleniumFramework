package pages;

import org.openqa.selenium.By;

public class UILocators {

	By Study_Opt = By.xpath("//button[contains(text(),'Masters')]"); //University college finder page
	
	//Step 1 of 4 page locators
	By Study_country = By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']/div[1]/main[1]/div[1]/div[1]/div[1]/span[1]/form[1]/div[1]/div[2]/div[1]/span[1]/div[1]/div[1]/div[1]/input[1]");
	By Study_country_choice = By.xpath("//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/span[1]/form[1]/div[1]/div[2]/div[1]/span[1]/div[1]/div[1]");
	By Study_major = By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']/div[1]/main[1]/div[1]/div[1]/div[1]/span[1]/form[1]/div[1]/div[2]/div[2]/span[1]/div[1]/div[1]/div[1]/input[1]");
	By Study_major_choice = By.xpath("//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/span[1]/form[1]/div[1]/div[2]/div[2]/span[1]/div[1]/div[1]");
	By Study_nextbtn = By.xpath("//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/span[1]/form[1]/div[2]/div[2]/button[1]");
	
	//Step 2 of 4 page locators
	By Undergrad_collgname = By.xpath("//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/span[1]/form[1]/div[1]/div[2]/div[1]/span[1]/div[1]/div[1]/div[1]/input[1]");
	By Undergrad_collgname_choice = By.xpath("//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/span[1]/form[1]/div[1]/div[2]/div[1]/span[1]/div[1]/ul[1]");
	By Undergrad_collgname_Major = By.xpath("//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/span[1]/form[1]/div[1]/div[2]/div[3]/span[1]/div[1]/div[1]/div[1]/input[1]");
	By Undergrad_collgname_Major_Choice = By.xpath("//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/span[1]/form[1]/div[1]/div[2]/div[3]/span[1]/div[1]/ul[1]");
	By Undergrad_collgname_marks = By.id("marks"); //xpath("//input[@id='marks']");
	By Undergrad_collgname_nxtbtn = By.linkText("Next"); //xpath("//button[contains(text(),'Next')]");
	
	//Step 3 of 4 page locators
	By Test_Scores_IELTS = By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']/div[1]/main[1]/div[1]/div[1]/div[1]/span[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]");
	By Test_Scores_IELTS_Marks = By.id("ielts_overall_score"); //xpath("//input[@id='ielts_overall_score']");
	By Test_scores_GMAT = By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']/div[1]/main[1]/div[1]/div[1]/div[1]/span[1]/form[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]");
	By Test_scores_GMAT_Marks = By.xpath("//input[@id='total_gmat_score']");
	By Test_Scores_nxtbtn = By.xpath("//button[contains(text(),'Next')]");
	
	//Step 4 of 4 page locators
	By Exp_count = By.id("work_exp"); //xpath("//input[@id='work_exp']");
	By Rel_papers = By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']/div[1]/main[1]/div[1]/div[1]/div[1]/span[1]/form[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]");
	By Rel_projects = By.id("project"); //xpath("//input[@id='project']");
	By Find_universities = By.xpath("//button[contains(text(),'Find Universities')]");
	
	By LogIn_btn = By.xpath("//button[contains(text(),'Log in')]");
}
