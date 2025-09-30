package com.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
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

        String folderPath = "test-output/screenshots/";
        String filePath = folderPath + testName + "_" + date + ".png";

        try {
            //Take screenshot as File
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            //Ensure directory exists
            Files.createDirectories(Paths.get(folderPath));

            //Save file
            Files.copy(src.toPath(), Paths.get(filePath));

            //Base64 version for embedding in reports
            byte[] fileContent = Files.readAllBytes(Paths.get(filePath));
            String encodedBase64 = Base64.getEncoder().encodeToString(fileContent);

            //Return Data URI (base64) → can be embedded directly in HTML reports
            return "data:image/png;base64," + encodedBase64;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
