package com.t3resources.testNGCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.t3resources.pages.t3HomeFactoryPage;
import com.t3resources.pages.t3JavaFactoryPage;
import com.t3resources.pages.t3TECPFactoryPage;
import com.t3resources.pages.t3TuitionFactoryPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

  
  
public class testNGRegression {
  
	  public static WebDriver driver;
	  public static t3HomeFactoryPage t3hp;
	  public static t3JavaFactoryPage t3jfp;
	  public static t3TuitionFactoryPage t3tfp;
	  public static t3TECPFactoryPage t3jsfp;

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("Nothing needed to be done beforeSuite");
	  }
	
	  @BeforeTest
	  public void launchBroswer() {
		  //before test cases execute set chrome driver
		  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");		
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 }
	
	  @BeforeClass
	  public void oepnWebSiteForTesting() {
	      //can go in beforeTest i.e. along with creating chrome driver - but sake of testing before test doing here
		  driver.get("http://t3-resources.com");
	  }
	  
	  @BeforeMethod
	  public void setHomeFactoryPage () {
		  t3hp = PageFactory.initElements(driver, t3HomeFactoryPage.class);
		  t3tfp = PageFactory.initElements(driver, t3TuitionFactoryPage.class);
		  t3jfp = PageFactory.initElements(driver, t3JavaFactoryPage.class);
		  t3jsfp = PageFactory.initElements(driver, t3TECPFactoryPage.class);
	  }
	  
	  @Test(priority=1)
	  public void testClickAndVerifyAboutUsPage () {
		  t3hp.clicAboutUs();//click on about us and then verify page opened is t3 about us page
		  t3hp.varifyAboutUsPage();//verify t3 about us page
	  }
	  
	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("Nothing needed to be done afterMethod - we will need browser open for below tests");
	  }
	
	  
	  @Test(priority=2)
	  public void testClickAndVerifyJavaPage () {
		//click on Course > Software Development > Java sub menu
		t3hp.clickJavaCourse();
		//we are in java page of t3 
		t3jfp.verifyJavaPage();
	  }
	  	  
	  @Test(priority=3)
	  public void testClickTutionMenuPage () {
			//click on tuition link
			t3tfp.clickTutionLink();
	  }
	  
	  @Test(priority=4)
	  public void testClickTutionEligibilityLink () {
			//click check eligibility page
			t3tfp.clickCheckEligibilityButton();
	  }
	  
	  @Test(priority=5)
	  public void testEligibilityPageVerifyClose () {
			//verify page open in new tab via new page title
			t3jsfp.verifyJobSeekerPage();
			//close subscription pop-up window
			t3jsfp.closeSubscriptionPopup();
	  }
	  
	  @Test(priority=6)
	  public void verifyT3HomePageFooterSection () {
		//verify 3 locations
		t3hp.varifyLocations();
	  }
	  
	  @AfterClass
	  public void closeBrowser() {
		  System.out.println("close browser AfterClass");
		  driver.close();//close browser 
	  }
	
	  @AfterTest
	  public void quitBrowser() {
		  System.out.println("quite browser AfterTest");
		  driver.quit();//quit can be in close but to test afterTest executed and after afterClass in testNG
	  }
	
	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("Nothing needed to be done afterSuite");
	  }

}
