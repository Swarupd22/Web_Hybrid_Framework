package com.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.utils.DriverFactory;
import com.utils.ReportManager;
import com.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting test: " + result.getName());
        String testName = result.getMethod().getMethodName();
        String description = result.getMethod().getDescription();

        ReportManager.createTest(testName,description)
                .assignCategory(result.getMethod().getGroups())
                .assignAuthor("Swarup");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
        ReportManager.getTest().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        WebDriver driver = DriverFactory.getInstance().getDriver();
        String base64Screenshot = ScreenshotUtils.captureScreenshot(driver, result.getName());

        if (base64Screenshot != null && !base64Screenshot.isEmpty()) {
            ReportManager.getTest().fail(result.getThrowable(),
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } else {
            ReportManager.getTest().fail(result.getThrowable());
            ReportManager.getTest().warning("Screenshot capture failed!");
        }
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting Test Suite: " + context.getName());
        // Initialize once
        ReportManager.getInstance();
        System.out.println("+++Extent Report initialized+++");
    }

    @Override
    public void onFinish(ITestContext context) {
        // flush at end
        ReportManager.flush();
        System.out.println("Finished Test Suite: " + context.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ReportManager.getTest().skip("Test Skipped : " + result.getThrowable());
    }
}
