package com.t3resources.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class t3TECPFactoryPage {
	public WebDriver driver;
	public ArrayList<String> tabPages;
	public t3TECPFactoryPage(WebDriver driver)
	{
		this.driver = driver;	
	}

	@FindBy(xpath="//*[@title='Close subscription dialo']")
	WebElement closeSubscriptionButton;
	
	@FindBy(xpath="//*[@id='btnEnrollNow']")
	WebElement checkEligibilityBtn;
	
	public void verifyJobSeekerPage()
	{
		//System.out.println("page title: "+driver.getTitle());
		tabPages = new ArrayList<String>(driver.getWindowHandles());
		//System.out.println("Windows tab page count: "+tabPages.size());
		//if tab page is open then we know job seeker page is opened in 2nd tab page
		if (tabPages.size()==2)
		{
			driver.switchTo().window(tabPages.get(1));
			//System.out.println("page title: "+driver.getTitle());
			if (driver.getTitle().equals("TEC-P"))
			{
				System.out.println("Job Seekers Page Verified.");
			}
		}
		
	}
	
	public void closeSubscriptionPopup()
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		//below will not work as page factory tried to find element before its visible
		//wait.until(ExpectedConditions.elementToBeClickable(closeSubscriptionButton));
		//below will wait for 20 seconds before pop-up window is visible and then finds element so we can click on it after it's been located
		WebElement closeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Close subscription dialog']")));
		closeBtn.click();
	}
	
	public void goBackToT3Resources()
	{
		driver.switchTo().window(tabPages.get(0));//0 is t3 tab page i.e. first
	}
	

}
