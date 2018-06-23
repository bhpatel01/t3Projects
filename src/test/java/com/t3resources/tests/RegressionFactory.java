package com.t3resources.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.t3resources.pages.t3HomeFactoryPage;
import com.t3resources.pages.t3JavaFactoryPage;
import com.t3resources.pages.t3TECPFactoryPage;
import com.t3resources.pages.t3TuitionFactoryPage;

public class RegressionFactory {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://t3-resources.com");
		
		t3HomeFactoryPage t3hp = PageFactory.initElements(driver, t3HomeFactoryPage.class);
		t3JavaFactoryPage t3jfp = PageFactory.initElements(driver, t3JavaFactoryPage.class);
		t3TuitionFactoryPage t3tfp = PageFactory.initElements(driver, t3TuitionFactoryPage.class);
		t3TECPFactoryPage t3jsfp = PageFactory.initElements(driver, t3TECPFactoryPage.class);
		
		
		
		t3hp.clicAboutUs();//click on about us and then verify page opened is t3 about us page
		t3hp.varifyAboutUsPage();//verify t3 about us page
		t3hp.clickJavaCourse();//click on Course > Software Development > Java submenu
		
		//we are in java page of t3 
		t3jfp.verifyJavaPage();
		//click on tuition link
		t3tfp.clickTutionLink();
		//click check eligibility page
		t3tfp.clickCheckEligibilityButton();
		//verify page open in new tab via new page title
		t3jsfp.verifyJobSeekerPage();
		//close subscription pop-up window
		t3jsfp.closeSubscriptionPopup();
		//send control back to t3 page
		t3jsfp.goBackToT3Resources();
		//verify 3 locations
		t3hp.varifyLocations();
		driver.quit();
	}

}
