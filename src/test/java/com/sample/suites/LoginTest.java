package com.sample.suites;

import com.sample.pagesobjects.LoginPage;
import com.sample.utils.ConfigReader;
import com.sample.utils.DriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Slf4j
public class LoginTest {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeTest
    public void setUp() throws IllegalAccessException {
        driverFactory = DriverFactory.getInstance();
        driverFactory.setDriver(ConfigReader.readFromPropFile("browser"));
        driver = driverFactory.getDriver();
        loginPage = new LoginPage(driver);

    }

    @Test(priority = 0)
    public void launchBrowser() throws IllegalAccessException {
        loginPage.openURL(ConfigReader.readFromPropFile("baseUrl"));
        log.info("+++++Browser launched and navigated to sauceDemo website");
    }

    @Test(priority = 1)
    public void login() throws Exception {
        loginPage.enterUsername(ConfigReader.readFromPropFile("username"));
        log.info("+++++Entered UserName+++++");

        loginPage.enterPassword(ConfigReader.readFromPropFile("password"));
        log.info("+++++Entered password+++++");

        loginPage.clickLogin();
        log.info("+++++Clicked login button+++++");

        loginPage.verifyHomePage();
        log.info("+++++Successfully logged in and navigated to home screen+++++");
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driverFactory.quitBrowser();
    }
}
