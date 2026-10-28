package com.sdet.factory;

import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.sdet.config.ConfigManager;

public class DriverFactory {

	private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

	private DriverFactory() {
		// Prevents creating instance of this utility class
	}

//	Get DRIVER
	public static WebDriver getDriver() {
		WebDriver driver = DRIVER.get();

		if (driver == null) {
			throw new IllegalStateException("Webdriver has not been initialized");
		}
		return driver;
	}

//	Initialise Driver type
	public static void initDriver(String browser) {

		WebDriver driver;

		if (DRIVER.get() != null) {
			throw new IllegalStateException("Webdriver already initialized for this thread");
		}

		boolean headless = Boolean.parseBoolean(ConfigManager.get("headless"));

		switch (browser.toLowerCase(Locale.ROOT)) {

		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			if (headless) {
				chromeOptions.addArguments("--headless");
			}
			
			driver = new ChromeDriver(chromeOptions);
			break;

		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();

			if (headless) {
				firefoxOptions.addArguments("--headless");
			}
			
			driver = new FirefoxDriver(firefoxOptions);
			break;

		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();

			if (headless) {
				edgeOptions.addArguments("--headless");
			}

			driver = new EdgeDriver();
			break;

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		DRIVER.set(driver);
		getDriver().manage().window().setSize((new org.openqa.selenium.Dimension(1440, 900)));
		System.out.println("Browser is : " + browser + " | Headless : " + headless);

	}

//	Remove DRIVER
	public static void quitDriver() {

		WebDriver driver = DRIVER.get();

		try {
			if (driver != null) {
				driver.quit();
			}
		} finally {
			DRIVER.remove();
		}

	}

}
