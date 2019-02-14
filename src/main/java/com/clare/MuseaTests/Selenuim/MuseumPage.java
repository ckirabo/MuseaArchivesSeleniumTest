package com.clare.MuseaTests.Selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MuseumPage {
	
	@FindBy(xpath = "//*[@id=\"searchBoxId\"]")
	private WebElement searchBox;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/nav/div/div/div/div[2]/div/h2")
	private WebElement hatMuseum;
	
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/nav/div/div/div/div[2]/div[4]/h2")
	private WebElement artzuMusuem;

	
	public String findHatMuseum(WebDriverWait wait) {
		
		searchBox.click();
		searchBox.sendKeys("hat");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div/div/div/div[2]/div/h2")));

		
		return hatMuseum.getText();
		

		
	}
	


	public String artToArtZuGallery(WebDriverWait wait, JavascriptExecutor js) {
		searchBox.click();
		searchBox.sendKeys("art");
		js.executeScript("window.scrollBy(0,1000)");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div/div/div/div[2]/div[4]/h2")));
		return artzuMusuem.getText();
	}
	
	
}
