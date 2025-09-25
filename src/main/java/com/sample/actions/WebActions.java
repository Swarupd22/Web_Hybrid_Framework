package com.sample.actions;

import com.sample.utils.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class WebActions {

    public void waitForElementToBeVisible(By locator) throws IllegalAccessException {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofMillis(500));
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForElementToBeClickable(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isElementDisplayed(By locator) {
        try {
            return DriverFactory.getInstance().getDriver().findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void openURL(String URL) {
        DriverFactory.getInstance().getDriver().get(URL);
        System.out.println("Successfully Entered URL - " + URL);
    }

    public void Click(By locator) throws IllegalAccessException {
        waitForElementToBeVisible(locator);
        DriverFactory.getInstance().getDriver().findElement(locator).click();
        System.out.println("Successfully clicked");
    }

    public void sendKeys(By locator, String text) throws IllegalAccessException {
        waitForElementToBeVisible(locator);
        DriverFactory.getInstance().getDriver().findElement(locator).sendKeys(text);
        System.out.println("Successfully entered text - " + text);
    }

    public String getText(By locator) throws IllegalAccessException {
        waitForElementToBeVisible(locator);
        return DriverFactory.getInstance().getDriver().findElement(locator).getText();
    }

    public void implicitWait() {
        DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void maximizeWindow() {
        DriverFactory.getInstance().getDriver().manage().window().maximize();
    }

    public void assertElementText(By locator, String expectedText) {
        try {
            WebElement element = DriverFactory.getInstance().getDriver().findElement(locator);
            Assert.assertEquals(expectedText, element.getText(), "Element text doesn't match the expected value");
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + locator.toString());
        }
    }

    public void assertIsElementVisible(By locator) {
        try {
            WebElement element = DriverFactory.getInstance().getDriver().findElement(locator);
            Assert.assertTrue(element.isDisplayed(), "Element is not visible");
            System.out.println("Element is visible");
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + locator.toString());
        }
    }

    public void clear(By locator) {
        DriverFactory.getInstance().getDriver().findElement(locator).clear();
        System.out.println("Successfully cleared text");
    }

    public void clearAndSendKeys(By locator, String text) {
        DriverFactory.getInstance().getDriver().findElement(locator).clear();
        DriverFactory.getInstance().getDriver().findElement(locator).sendKeys(text);
        System.out.println("Successfully Entered text - " + text);
    }

    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
        js.executeScript("window.scrollBy(0, -700);");
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
        js.executeScript("window.scrollBy(0,700);");
    }

    public void waitAnClick(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            DriverFactory.getInstance().getDriver().findElement(locator).click();
            System.out.println("Successfully clicked");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectByVisibleText(By locator, String value) throws IllegalAccessException {
        waitForElementToBeVisible(locator);
        WebElement dropdown = DriverFactory.getInstance().getDriver().findElement(locator);
        Select sel = new Select(dropdown);
        sel.selectByVisibleText(value);
        System.out.println("Successfully selected dropdown value - " + value);
    }

    public boolean isEnabled(By locator) throws IllegalAccessException {
        waitForElementToBeVisible(locator);
        return DriverFactory.getInstance().getDriver().findElement(locator).isEnabled();
    }

    public void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());
        DriverFactory.getInstance().getDriver().switchTo().alert().accept();
        System.out.println("Successfully handled the alert!");
    }

    public void dismissAlert() {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());
        DriverFactory.getInstance().getDriver().switchTo().alert().dismiss();
        System.out.println("Successfully dismissed the alert!");
    }

    public void switchToDefaultContent() {
        DriverFactory.getInstance().getDriver().switchTo().defaultContent();
        System.out.println("Successfully switched to default content!");
    }

    public void switchToFrame(By locator) throws IllegalAccessException {
        waitForElementToBeVisible(locator);
        WebElement frameElement = DriverFactory.getInstance().getDriver().findElement(locator);
        DriverFactory.getInstance().getDriver().switchTo().frame(frameElement);
        System.out.println("Successfully switched to frame!");
    }

    public void switchToParentFrame() {
        DriverFactory.getInstance().getDriver().switchTo().parentFrame();
        System.out.println("Successfully switched to parent frame!");
    }

    public void doubleClick(By locator) throws IllegalAccessException {
        waitForElementToBeVisible(locator);
        WebElement element = DriverFactory.getInstance().getDriver().findElement(locator);
        Actions actions = new Actions(DriverFactory.getInstance().getDriver());
        actions.doubleClick(element).perform();
        System.out.println("Successfully performed double click!");
    }

    public void rightClick(By locator) throws IllegalAccessException {
        waitForElementToBeVisible(locator);
        WebElement element = DriverFactory.getInstance().getDriver().findElement(locator);
        Actions actions = new Actions(DriverFactory.getInstance().getDriver());
        actions.contextClick(element).perform();
        System.out.println("Successfully performed right click!");
    }

    public void refreshPage() {
        DriverFactory.getInstance().getDriver().navigate().refresh();
        System.out.println("Successfully refreshed the page!");
    }

    public void clickAndSendKeys(By locator, String text) {
        WebElement element = DriverFactory.getInstance().getDriver().findElement(locator);
        element.clear();
        element.click();
        element.sendKeys(text);
        System.out.println("Successfully Entered text - " + text);
    }

    public void navigateBack() {
        DriverFactory.getInstance().getDriver().navigate().back();
        System.out.println("Successfully navigated back!");
    }

    public void navigateToURL(String url) {
        DriverFactory.getInstance().getDriver().navigate().to(url);
        System.out.println("Successfully navigated to URL: " + url);
    }

    public void switchWindow() {
        String baseWin = DriverFactory.getInstance().getDriver().getWindowHandle();
        System.out.println(baseWin);
        Set<String> handles = DriverFactory.getInstance().getDriver().getWindowHandles();
        List<String> list = new ArrayList<>(handles);
        System.out.printf("the list " + list);
        DriverFactory.getInstance().getDriver().switchTo().window(list.get(1));
        System.out.println(DriverFactory.getInstance().getDriver().switchTo().window(list.get(1)));
    }

    public List<WebElement> getListOfElements(By locator) throws IllegalAccessException {
        waitForElementToBeVisible(locator);
        List<WebElement> elements = DriverFactory.getInstance().getDriver().findElements(locator);
        System.out.println("Successfully get element size - " + elements.size());
        return elements;
    }
}
