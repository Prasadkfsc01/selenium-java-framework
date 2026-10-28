
package com.sdet.tests;

import com.sdet.config.ConfigManager;
import com.sdet.factory.DriverFactory;
import com.sdet.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverFactory.initDriver(
            ConfigManager.get("browser")
        );
    }

    @Test
    public void verifySuccessfulLogin() {

        DriverFactory.getDriver().get(
            ConfigManager.get("baseUrl")
        );

        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

        loginPage.login(
            "standard_user",
            "secret_sauce"
        );

        Assert.assertTrue(
            DriverFactory.getDriver()
                .getCurrentUrl()
                .contains("/inventory.html"),
            "Login failed: Inventory page not displayed"
        );
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
