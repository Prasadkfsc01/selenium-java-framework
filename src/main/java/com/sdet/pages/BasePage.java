package com.sdet.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sdet.config.ConfigManager;

public abstract class BasePage {
	
	
	protected final WebDriver driver;
	protected final WebDriverWait wait;
	
	protected BasePage(WebDriver driver) {
		
		this.driver = driver;
		
		int timeout = Integer.parseInt(ConfigManager.get("explicitWait"));
		
		this.wait = new WebDriverWait(
				driver, Duration.ofSeconds(timeout));
	}
	
//	Method to wait for element to be clickable and click on element
	
	protected void click(By locator) {
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	
//	Method to wait for element to be located and pass value
	protected void type(By locator, String value) {
		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(value);
	}
	
//	Method to wait for element to be located and get Text
	 protected String getText(By locator) {

	        WebElement element = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(locator)
	        );

	        return element.getText();
	    }

//	 Method for the element to be visible and located and displayed 
	 
	    protected boolean isVisible(By locator) {

	        return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(locator)
	        ).isDisplayed();
	    }
}
