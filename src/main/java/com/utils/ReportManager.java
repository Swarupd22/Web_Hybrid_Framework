package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") +
                    "/test-output/reports/ExtentReport_" + ScreenshotUtils.date + ".html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setDocumentTitle("Automation Report");
            reporter.config().setReportName("Automation Test Execution");
            reporter.config().thumbnailForBase64(true);

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Environment", ConfigReader.readFromPropFile("env"));
            extent.setSystemInfo("Browser", ConfigReader.readFromPropFile("browser"));
        }
        return extent;
    }

    // Create a new test
    public static ExtentTest createTest(String testName, String description) {
        ExtentTest test = getInstance().createTest(testName, description);
        extentTest.set(test);
        return test;
    }

    // Get current test
    public static ExtentTest getTest() {
        return extentTest.get();
    }

    // Flush reports
    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}