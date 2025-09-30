package com.suites;

import base.BaseTest;
import com.pagesobjects.LoginPage;
import com.utils.ConfigReader;
import com.utils.DriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

@Slf4j
public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeTest
    public void init() {
        WebDriver driver = DriverFactory.getInstance().getDriver();
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

}
