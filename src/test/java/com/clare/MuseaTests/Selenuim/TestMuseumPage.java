package com.clare.MuseaTests.Selenuim;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestMuseumPage {
	
	public static ExtentReports report;
	public static ExtentTest test;

	WebDriver driver;
	WebDriverWait wait;
	
	JavascriptExecutor js; 
	
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
		js = (JavascriptExecutor) driver;
	}

	
	@Test
	public void testMusuemPageSearchHat() {
		
		test = report.startTest("Starting Test ... Search For Hat Museum");

		test.log(LogStatus.INFO, "Browser Started");
		
		driver.get(Constants.URLMUSEUMS);
		
		MuseumPage page1 = PageFactory.initElements(driver, MuseumPage.class);
		

		
		assertEquals("Did not recieve the Hat Museum as a result","Hat Works",page1.findHatMuseum(wait));
	}
	
	@Test
	public void testArtGivesArtzuGallery() {
		
		test = report.startTest("Starting Test ... Search For Checking Art brings Artzu Gallery");

		test.log(LogStatus.INFO, "Browser Started");
		
		driver.get(Constants.URLMUSEUMS);
		
		MuseumPage page2 = PageFactory.initElements(driver, MuseumPage.class);
		
		assertEquals("Did not recieve the Artzu Gallery as a result","Artzu Gallery",page2.artToArtZuGallery(wait,js));
		
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
