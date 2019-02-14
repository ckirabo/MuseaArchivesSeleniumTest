package com.clare.MuseaTests.Selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	

	@FindBy(xpath = "//*[@id=\"random\"]")
	private WebElement randomButton;
	
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/nav/div/div/div[2]/div[2]/div/div/h2")
	private WebElement randomMuseum;
	
	
	
	@FindBy(xpath = "//*[@id=\"topNavJS\"]/a[2]")
	private WebElement museumNavBar;

	
	@FindBy(xpath = "//*[@id=\"searchBoxId\"]")
	private WebElement searchBox;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/nav/div/div/div/div[2]/div/h2")
	private WebElement searchedMusuem;


	public boolean showMusuem(WebDriverWait wait) {

		
		randomButton.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div/div/div[2]/div[2]/div/div/h2")));
		
		if(randomMuseum.getText() != "") {
			return true;
		}
		
		return false;
	}



	public String navigateToMuseumsPage(WebDriverWait wait) {
		
		museumNavBar.click();
		searchBox.click();
		searchBox.sendKeys("hist");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]/nav/div/div/div/div[2]/div/h2")));
		
		return searchedMusuem.getText();
	}
	
	

}
