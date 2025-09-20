package com.sample.suites;

import com.sample.pages.LoginPage;
import com.sample.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class LoginTest {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private LoginPage loginPage;
    
    @BeforeTest
    public void setUp() throws IllegalAccessException {
        driverFactory = DriverFactory.getInstance();
        driverFactory.setDriver("chrome");
        driver = driverFactory.getDriver();
        loginPage = new LoginPage(driver);

    }

    @Test(priority = 0)
    public void launchBrowser() throws IllegalAccessException {
        loginPage.openURL("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void login() throws Exception {
      loginPage.enterUsername("standard_user");
      loginPage.enterPassword("secret_sauce");
      loginPage.clickLogin("login button");
      loginPage.verifyHomePage("Home Page");
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driverFactory.quitBrowser();
    }
}
