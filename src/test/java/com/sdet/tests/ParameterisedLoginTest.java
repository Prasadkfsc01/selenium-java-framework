
package com.sdet.tests;

import com.sdet.config.ConfigManager;
import com.sdet.data.LoginDataProvider;
import com.sdet.factory.DriverFactory;
import com.sdet.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParameterisedLoginTest {

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		DriverFactory.initDriver(ConfigManager.get("browser"));
		DriverFactory.getDriver().get(ConfigManager.get("baseUrl"));
	}

	@Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
	public void verifyLogin(String username, String password, boolean shouldLogin) {

		LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
		loginPage.login(username, password);

		if (shouldLogin) {

			Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("/inventory.html"),
					"Expected successful login for: " + username);

		} else {

			Assert.assertFalse(loginPage.getErrorMessage().isBlank(), "Expected login error for: " + username);
		}
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DriverFactory.quitDriver();
	}
}
