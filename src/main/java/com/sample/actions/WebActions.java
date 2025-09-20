package com.sample.actions;

import com.sample.utils.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class WebActions {

    public WebElement waitForVisible_MilliSeconds(By locator) throws IllegalAccessException {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofMillis(500));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void openURL(String URL) throws IllegalAccessException {
        DriverFactory.getInstance().getDriver().get(URL);
        System.out.println("Successfully Entered URL - " + URL);
    }

    public WebDriver.Timeouts implicitWait() throws IllegalAccessException {
        return DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void maximizeWindow() throws IllegalAccessException {
        DriverFactory.getInstance().getDriver().manage().window().maximize();
    }

    public void Click(By locator, String info) throws IllegalAccessException {
        WebElement elm = waitForVisible_MilliSeconds(locator);
        if (!elm.isSelected()) {
            elm.click();
        }
        System.out.println("Successfully clicked on - " + info);
    }

    public void sendKeys(By locator, String text) throws IllegalAccessException {
        WebElement elm = waitForVisible_MilliSeconds(locator);
        elm.sendKeys(text);
        System.out.println("Successfully entered text - " + text);
    }

    public void assertElementText(By locator, String expectedText) {
        try {
            WebElement element = DriverFactory.getInstance().getDriver().findElement(locator);
            Assert.assertEquals("Element text doesn't match the expected value", expectedText, element.getText());
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + locator.toString());
        }
    }

    public void assertElementVisible(By locator, String info) throws IllegalAccessException {
        try {
            WebElement element = DriverFactory.getInstance().getDriver().findElement(locator);
            Assert.assertTrue(element.isDisplayed(), "Element is not visible");
            System.out.println(info + " Element is visible");
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + locator.toString());
        }
    }

    public boolean isDisplayed(By locator, String info) throws IllegalAccessException {
        WebElement elm = waitForVisible_MilliSeconds(locator);
        boolean isPresent = elm.isDisplayed();
        if (isPresent) {
            System.out.println("Successfully element displayed: " + info);
        } else {
            System.out.println("element not displayed: " + info);
        }
        return isPresent;
    }
//
//    public void clearAndSendKeys(By locator, String text) {
//        WebElement elm = waitForVisible_MilliSeconds(locator);
//        elm.clear();
//        elm.sendKeys(text);
//        System.out.println("Successfully Entered text - " + text);
//    }
//
//    public void clear(By locator) {
//        WebElement elm = waitForVisible_MilliSeconds(locator);
//        elm.clear();
//        System.out.println("Successfully Cleared text");
//    }
//
//    public void Scroll_up() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, -700);");
//    }
//
//    public void Scroll_down() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, 1000);");
//    }
//
//    public void scrollDownUsingJS() {
//        scrollBarPresent.executeScript(
//                "window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)", "");
//    }
//
//    public void scrollUpUsingJS() {
//        scrollBarPresent.executeScript("window.scrollBy(0,350)", "");
//    }

    /////////////////////////////////////////////////////////////////////////

//    public void alertAccepthHandling() {
//        WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), Duration.ofSeconds(30));
//        if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
//            DriverFactory.getInstance().getWebDriver().switchTo().alert().accept();
//            ReportManager.logInfo("Successfully handled the alert!");
//            System.out.println("Successfully handled the alert!");
//        }
//    }
//
//    public void waitforbuttonandclick(By locator, String info) {
//        WebElement elm = waitForVisible_longerMilliSeconds(locator);
//        if (elm.isEnabled()) {
//            elm.click();
//            ReportManager.logInfo("Successfully clicked on - " + info);
//            System.out.println("Successfully clicked on - " + info);
//        }
//    }
//
//    public void scrollDownUsingJS() {
//        scrollBarPresent.executeScript(
//                "window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)", "");
//    }
//
//    public void scrollUpUsingJS() {
//        scrollBarPresent.executeScript("window.scrollBy(0,350)", "");
//    }
//
//
//    public void openURL(String URL) {
//        DriverFactory.getInstance().getWebDriver().get(URL);
//        String strActualText = DriverFactory.getInstance().getWebDriver().getCurrentUrl();
//        ReportManager.logInfo("Successfully Entered URL - " + URL);
//        System.out.println("Successfully Entered URL - " + URL);
//    }
//
//    public void Click(By locator, String info) {
//        WebElement elm = waitForVisible_MilliSeconds(locator);
//        if (!elm.isSelected()) {
//            elm.click();
//        }
//        elm.click();
//        ReportManager.logInfo("Successfully clicked on - " + info);
//        System.out.println("Successfully clicked on - " + info);
//    }
//
//    public void selectByVisibleText(By locator, String value) {
//        WebElement elm = waitForVisible_MilliSeconds(locator);
//        Select sel = new Select(DriverFactory.getInstance().getWebDriver().findElement(locator));
//        sel.selectByVisibleText(value);
//        ReportManager
//                .logInfo("Successfully selected dropdown value - " + "<b style=\"color:green;\">" + value + "</b>");
//
//    }
//
//    public void sendKeys(By locator, String text) {
//        WebElement elm = waitForVisible_MilliSeconds(locator);
//        elm.sendKeys(text);
//        ReportManager.logInfo("Successfully Entered text - " + text);
//        System.out.println("Successfully Entered text - " + text);
//    }
//
//    public String getElmText(By locator) {
//        WebElement elm = waitForVisible_MilliSeconds(locator);
//        String elamText = elm.getText();
//        ReportManager.logInfo("Successfully get element text - " + elamText);
//        System.out.println("Successfully get element text - " + elamText);
//        return elamText;
//    }
//

    //
//    public boolean isEnabled(By locator, String info) {
//        WebElement elm = waitForVisible_MilliSeconds(locator);
//        boolean isEnable = elm.isEnabled();
//        if (isEnable) {
//            ReportManager.logInfo("Element Enabled: " + info);
//            System.out.println("Element Enabled: " + info);
//        } else {
//            ReportManager.logInfo("Element Disabled: " + info);
//            System.out.println("Element Disabled: " + info);
//        }
//        return isEnable;
//    }
//
//    public void clearAndSendKeys(By locator, String text) {
//        WebElement elm = waitForVisible_MilliSeconds(locator);
//        elm.clear();
//        elm.sendKeys(text);
//        ReportManager.logInfo("Successfully Entered text - " + text);
//        System.out.println("Successfully Entered text - " + text);
//    }
//
//    public void pressEnter(By locator) {
//        WebElement elm = waitForVisible_MilliSeconds(locator);
//        elm.sendKeys(Keys.ENTER);
//        ReportManager.logInfo("Successfully Pressed ENTER");
//        System.out.println("Successfully Pressed ENTER");
//    }
//
//    public void clear(By locator) {
//        WebElement elm = waitForVisible_MilliSeconds(locator);
//        elm.clear();
//        ReportManager.logInfo("Successfully Cleared text - ");
//        System.out.println("Successfully Cleared text ");
//    }
//
//    public void verifyText(String actualText, String expectedText) {
//        ReportManager.logInfo("Actual Text - " + actualText);
//        ReportManager.logInfo("Expected Text - " + expectedText);
//        System.out.println("Actual Text - " + actualText);
//        System.out.println("Expected Text - " + expectedText);
//        assertEquals(actualText, expectedText);
//    }
//
//    public void verifyIntValues(int actualValue, int expectedValue) {
//        ReportManager.logInfo("Actual Value - " + actualValue);
//        ReportManager.logInfo("Expected Value - " + expectedValue);
//        System.out.println("Actual Value - " + actualValue);
//        System.out.println("Expected Value - " + expectedValue);
//        assertEquals(actualValue, expectedValue);
//
//    }
//
//    public String getAttributeValue(By locator, String name) {
//        WebElement elm = waitForVisible_MilliSeconds(locator);
//        String attributeText = elm.getAttribute(name);
//        ReportManager.logInfo("Successfully get attribute text - " + attributeText);
//        System.out.println("Successfully get attribute text - " + attributeText);
//        return attributeText;
//    }
//
//    public boolean isScrollPresent() throws Exception {
//        String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
//        Boolean isScroll_Present = (Boolean) (scrollBarPresent.executeScript(execScript));
//        return isScroll_Present;
//
//    }
//
//    public void mouseHover(By locator) throws Exception {
//        WebElement elm = waitForVisible_MilliSeconds(locator);
//        //   action.moveToElement(elm).build().perform();
//        String elmText = elm.getText();
//        ReportManager.logInfo("Successfully mouse hover and get text - " + elmText);
//        System.out.println("Successfully mouse hover and get text - " + elmText);
//    }
//
//    public void switchToFrame(By locator) throws Exception {
//        WebElement elm = waitForVisible_MilliSeconds(locator);
//        DriverFactory.getInstance().getDriver().switchTo().frame(elm);
//        System.out.println("Successfully switched to frame ");
//    }
//
//    public List<WebElement> getListofElements(By locator, String name) {
//        waitForVisible_MilliSeconds(locator);
//        List<WebElement> lst_Elements = DriverFactory.getInstance().getWebDriver().findElements(locator);
//        ReportManager.logInfo("Successfully get element size - " + lst_Elements.size());
//        System.out.println("Successfully get element size - " + lst_Elements.size());
//        return lst_Elements;
//    }
//
//    public void ClickJSE(By locator, String info) {
//        WebElement elm = waitForVisible_MilliSeconds(locator);
//        scrollBarPresent.executeScript("arguments[0].click();", elm);
//        ReportManager.logInfo("Successfully clicked on - " + info);
//        System.out.println("Successfully clicked on - " + info);
//    }
//
//    public void navigateToURL(String url) {
//
//        DriverFactory.getInstance().getWebDriver().navigate().to(url);
//        String currentURL = DriverFactory.getInstance().getWebDriver().getCurrentUrl();
//        ReportManager.logInfo("Successfully navigated to URL: " + currentURL);
//        System.out.println("Successfully navigated to URL: " + currentURL);
//
//    }
//
//
//    public void pageRefresh() {
//        DriverFactory.getInstance().getWebDriver().navigate().refresh();
//
//    }
//
//
//    public void clickAndSendKeys(String locator, String text) {
//
//        By dist = By.xpath("//td[text()='" + locator + "']/following-sibling::td[2]//input[@type='text']");
//
//        WebElement elm = waitForVisible_MilliSeconds(dist);
//        elm.clear();
//        elm.sendKeys(text);
//        ReportManager.logInfo("Successfully Entered text - " + text);
//        System.out.println("Successfully Entered text - " + text);
//
//    }
//
//
//    public void Scroll_up() {
//        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
//        js.executeScript("window.scrollBy(0, -700);");
////        WebElement nextButton1 = DriverFactory.getInstance().getWebDriver().findElement(By.xpath("//a[@class='buttonFinish buttonDisabled']/following-sibling::a[1]"));
////        js.executeScript("arguments[0].scrollIntoView(true);", nextButton1);
//
//    }
//
//
//    public void Scroll_down() {
//        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
//        js.executeScript("window.scrollBy(0, 1000);");
//
//    }
//
//
//    public void Switch_frame() {
//        String baseWin = DriverFactory.getInstance().getWebDriver().getWindowHandle();
//        System.out.println(baseWin);
//        Set<String> handles = DriverFactory.getInstance().getWebDriver().getWindowHandles();
//        List<String> list = new ArrayList<>(handles);
//        System.out.printf("the list " + list);
//        DriverFactory.getInstance().getWebDriver().switchTo().window(list.get(1));
//        System.out.println(DriverFactory.getInstance().getWebDriver().switchTo().window(list.get(1)));
//    }
}
