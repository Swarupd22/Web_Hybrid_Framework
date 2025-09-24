package com.sample.pagesobjects;

import com.sample.actions.WebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    WebActions action = new WebActions();

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.xpath("//input[@data-test='login-button']");
    By cart = By.xpath("//*[@class='shopping_cart_link']");

    public void openURL(String URL) throws IllegalAccessException {
        action.openURL(URL);
        action.implicitWait();
        action.maximizeWindow();
    }

    public void enterUsername(String text) throws IllegalAccessException {
        action.sendKeys(username,text);
    }
    public void enterPassword(String text) throws IllegalAccessException {
        action.sendKeys(password,text);
    }

    public void clickLogin(String info) throws Exception {
        action.Click(loginBtn,info);
    }

    public void verifyHomePage(String info) throws IllegalAccessException {
        action.assertElementVisible(cart,info);
    }

    public void checkCart(String info) throws IllegalAccessException {
        action.Click(cart,info);
    }
}