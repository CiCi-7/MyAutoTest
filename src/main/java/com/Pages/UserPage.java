package com.Pages;

import com.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Zcc
 * @Date: 2023/11/05/17:03
 * @Description:
 */
public class UserPage {

    public static void userPage(ChromeDriver webDriver, String url) {
        String username = ConfigReader.getLoginUsername();
        String password = ConfigReader.getLoginPassword();
        webDriver.get(url);
        // 查找 "在线用户" 链接元素
        WebElement onlineUserLink = webDriver.findElement(By.linkText("在线用户"));

        // 执行点击操作
        onlineUserLink.click();
    }
}
