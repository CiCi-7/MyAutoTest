package com.utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Zcc
 * @Date: 2023/11/04/02:07
 * @Description:
 */
public class ConfigReader {

    private static Properties properties;

    static {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(ConfigReader.class.getClassLoader().getResource("").getPath()+"config.properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getWebDriverPath() {
        return properties.getProperty("webdriver.path");
    }

    public static String getLoginUsername() {
        return properties.getProperty("login.username");
    }

    public static String getLoginPassword() {
        return properties.getProperty("login.password");
    }
}
