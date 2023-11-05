package com.common;

import com.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Zcc
 * @Date: 2023/11/04/01:40
 * @Description:
 */
public class LoginPage {


    //测试登陆功能
    public static void loginTest(ChromeDriver webDriver, String url) {

        String username = ConfigReader.getLoginUsername();
        String password = ConfigReader.getLoginPassword();
        webDriver.get(url);
        // 由于页面没有唯一标识，通过相同className取索引下标定位
        final List<WebElement> elements = webDriver.findElements(By.className("el-input__inner"));
        // 用户名填写
        final WebElement nameinput = elements.get(0);
        nameinput.clear();
        nameinput.sendKeys(username);
        // 密码填写
        final WebElement pwdinput = elements.get(1);
        pwdinput.clear();
        pwdinput.sendKeys(password);

        // 验证码填写
        // 使用Duration对象定义等待超时
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(webDriver, timeout);

        webDriver.findElement(By.cssSelector(".el-button.el-button--primary.el-button--medium")).click();

        webDriver.close();
    }


}
