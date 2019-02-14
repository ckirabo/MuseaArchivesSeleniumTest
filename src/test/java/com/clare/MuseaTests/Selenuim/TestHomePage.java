package com.clare.MuseaTests.Selenuim;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestHomePage {

	public static ExtentReports report;
	public static ExtentTest test;

	WebDriver driver;
	WebDriverWait wait;
	
	
	
	@BeforeClass
	public static void startClass() {
		report = new ExtentReports(Constants.REPORTLOCATION +Constants.REPORTFILENAME );
	}
	
	@Before
	public void startUp() {
		System.setProperty("webdriver.chrome.driver", Constants.DRIVERLOCATION);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
		
	}

	
	@Test
	public void testRandomiser() {
		
		test = report.startTest("Starting Test ... RandomButton Generator");

		test.log(LogStatus.INFO, "Browser Started");
		
		driver.get(Constants.URLHOME);
		
		HomePage page1 = PageFactory.initElements(driver, HomePage.class);
		

		
		assertEquals("Did not show a museum", true , page1.showMusuem(wait));
	}
	
	
	@Test
	public void testHomeToMuseumPage() {
		
		test = report.startTest("Starting Test ... Navigation to other Pages");

		test.log(LogStatus.INFO, "Browser Started");
		
		driver.get(Constants.URLHOME);
		
		HomePage page2 = PageFactory.initElements(driver, HomePage.class);
		

		
		assertEquals("Did not navigate to the other page", "People’s History Museum" , page2.navigateToMuseumsPage(wait));
		
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
	@AfterClass
	public static void endClass() {
		report.endTest(test);
		report.flush();
	}
}
