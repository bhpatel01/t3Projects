package com.t3resources.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

//page factory
public class t3HomeFactoryPage {
	public WebDriver driver;
	
	public t3HomeFactoryPage(WebDriver driver)
	{
		this.driver = driver;	
	}

	@FindBy(partialLinkText="ABOUT US")
	WebElement aboutusLink;
	
	@FindBy(className="text-center")
	List<WebElement> classElements;
	
	@FindBy(partialLinkText="COURSES")
	WebElement coursesMenu;
	
	@FindBy(partialLinkText="SOFTWARE DEVELOPMENT")
	WebElement softwareDevMenu;
	
	@FindBy(partialLinkText="JAVA")
	WebElement javaMenu;
	
	@FindBy(xpath="//*[@href='contactus.php'][@class='text-white2']")
	List<WebElement> locations;
	
	public void clicAboutUs()
	{
		aboutusLink.click();
	}
	
	public void varifyAboutUsPage()
	{
		int	linkCount;
		linkCount = 0;
		for (WebElement e : classElements)
		{

			String name = e.getText();
			//System.out.println(">"+ name);
			if (name.equals("WHO WE ARE") || 
				name.equals("OUR SUCCESS STORY") || 
				name.equals("VISION AND MISSION")|| 
				name.equals("OUR SERVICES"))
			{
			linkCount = linkCount + 1;
			}
			
		}
		//System.out.println("matching texts found: "+ linkCount);
		if (linkCount == 4)
		{
			System.out.println("T3 About US Page Verified.");
		}
		
	}
	
	public void clickJavaCourse()
	{
		Actions	actions = new Actions(driver);
		actions.moveToElement(coursesMenu).perform();
		actions.moveToElement(softwareDevMenu).perform();
		javaMenu.click();
	}

	public void varifyLocations()
	{
		int	linkCount;
		linkCount = 0;
		for (WebElement e : locations)
		{

			String name = e.getText();
			//System.out.println(">"+ name);
			if (name.equals("Colorado") || 
				name.equals("Texas") || 
				name.equals("Canada"))
			{
			linkCount = linkCount + 1;
			}
			
		}
		//System.out.println("matching locations found: "+ linkCount);
		if (linkCount == 3)
		{
			System.out.println("T3 Locations Verified.");
		}
		
	}
}
