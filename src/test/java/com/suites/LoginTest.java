package com.suites;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import com.pagesobjects.LoginPage;
import com.utils.ConfigReader;
import com.utils.DriverFactory;
import com.utils.ReportManager;
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


    @Test(priority = 0, description = "Launch Browser and navigate to URL")
    public void launchBrowser() throws IllegalAccessException {
        ReportManager.getTest().log(Status.INFO, "Navigating to: " + ConfigReader.readFromPropFile("baseUrl"));
        loginPage.openURL(ConfigReader.readFromPropFile("baseUrl"));
        log.info("+++++Browser launched and navigated to sauceDemo website");
        ReportManager.getTest().log(Status.PASS, "Successfully launched the browser and navigated to URL");
    }

    @Test(priority = 1, description = "Login with valid credentials")
    public void login() throws Exception {
        ReportManager.getTest().info("Logging in with username: " + ConfigReader.readFromPropFile("username"));
        loginPage.enterUsername(ConfigReader.readFromPropFile("username"));
        log.info("+++++Entered UserName+++++");
        ReportManager.getTest().log(Status.PASS,"Successfully entered username");

        ReportManager.getTest().info("Logging in with password: " + ConfigReader.readFromPropFile("password"));
        loginPage.enterPassword(ConfigReader.readFromPropFile("password"));
        log.info("+++++Entered password+++++");
        ReportManager.getTest().log(Status.PASS,"Successfully entered password");

        ReportManager.getTest().info("Clicking on login button");
        loginPage.clickLogin();
        log.info("+++++Clicked login button+++++");
        ReportManager.getTest().log(Status.PASS,"Successfully clicked on login button");

        ReportManager.getTest().info("Verifying navigation to home screen by checking visibility of cart icon");
        loginPage.verifyHomePage();
        log.info("+++++Successfully logged in and navigated to home screen+++++");
        ReportManager.getTest().log(Status.PASS,"Successfully logged in and navigated to home screen");
    }

}
