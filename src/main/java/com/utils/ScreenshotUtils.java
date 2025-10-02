package com.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class ScreenshotUtils {

    static DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
    static Date currentdate = new Date();
    public static String date = dateFormat.format(currentdate);

    public static String captureScreenshot(WebDriver driver, String testName) {
        String folderPath = System.getProperty("user.dir") + "/test-output/screenshots/";
        String filePath = folderPath + testName + "_" + date + ".png";

        try {
            Files.createDirectories(Paths.get(folderPath));

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), Paths.get(filePath));

            System.out.println("Screenshot saved at : " + filePath);

            // return base64 for Extent
            byte[] fileContent = Files.readAllBytes(Paths.get(filePath));
            return Base64.getEncoder().encodeToString(fileContent);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
