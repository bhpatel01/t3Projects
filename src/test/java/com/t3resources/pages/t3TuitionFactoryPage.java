package com.t3resources.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class t3TuitionFactoryPage {
	public WebDriver driver;
	
	public t3TuitionFactoryPage(WebDriver driver)
	{
		this.driver = driver;	
	}

	@FindBy(partialLinkText="TUITION")
	WebElement tutionLink;
	
	@FindBy(xpath="//*[@id='btnEnrollNow']")
	WebElement checkEligibilityBtn;
	
	public void clickTutionLink()
	{
		tutionLink.click();
	}
	
	
	public void clickCheckEligibilityButton()
	{
		checkEligibilityBtn.click();
	}
	

}
