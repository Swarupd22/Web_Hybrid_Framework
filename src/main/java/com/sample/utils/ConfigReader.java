package com.sample.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try (FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties")) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String readFromPropFile(String key) {
        return properties.getProperty(key);
    }
}
