package com.t3resources.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class t3JavaFactoryPage {
	public WebDriver driver;
	
	public t3JavaFactoryPage(WebDriver driver)
	{
		this.driver = driver;	
	}

	@FindBy(partialLinkText="Enroll Now")
	WebElement enrollNowLink;
	
	@FindBy(partialLinkText="Enquire More")
	WebElement equireMoreLink;
	
	@FindBy(partialLinkText="TUITION")
	WebElement tutionLink;
	
	public void verifyJavaPage()
	{
		if (enrollNowLink.isDisplayed() && equireMoreLink.isDisplayed())
		{
			System.out.println("Java Page Verified.");
		}
		
	}
	
}
