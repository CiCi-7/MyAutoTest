
import com.Pages.UserPage;
import com.common.LoginPage;
import com.utils.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Zcc
 * @Date: 2023/11/04/00:29
 * @Description:
 */
public class Demo {

    public static void main(String[] args) {
       // System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        String webdriverPath = ConfigReader.getWebDriverPath();
        //给chromedriver进行一些设置，比如可以最大化窗口打开等
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        //LoginPage.loginTest((ChromeDriver) driver,"https://vue.ruoyi.vip/login?redirect=%2Findex");

        //UserPage.userPage((ChromeDriver)driver,"https://vue.ruoyi.vip/monitor/online");

        //打开网页
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("软件测试");
        driver.findElement(By.id("su")).click();
        // 页面下拉操作
       // ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,1000)");

        // 创建 Actions 类的实例
        Actions actions = new Actions(driver);
        // 模拟按下方向键向下
        actions.sendKeys(Keys.DOWN).perform();

        // 创建 JavaScript 执行器
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        WebElement element = null;
        // 循环滚动直到找到包含"百度百科"字样的元素
        while (true) {
            // 检查页面上是否存在包含"百度百科"字样的元素
            element = driver.findElement(By.xpath("//*[contains(text(), '百度百科')]"));

            // 如果找到了元素，停止滚动
            if (element != null) {
                break;
            }

            // 否则，继续向下滚动
            jsExecutor.executeScript("window.scrollBy(0, 100);"); // 向下滚动100像素
        }
        // 获取当前窗口句柄
        String mainWindowHandle = driver.getWindowHandle();

        // 找到百度百科之后，点击进入新的页面，并加入断言，是否开启了新的窗口
        element.click();

        // 显式等待新窗口打开，直到窗口句柄数量增加
        final Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));


        // 等待新窗口打开，直到窗口句柄数量增加
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // 获取所有窗口句柄
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                // 找到新窗口
                driver.switchTo().window(windowHandle);
                // 在新窗口执行断言或其他操作
                // 在新窗口之后，返回到原始窗口
                driver.switchTo().window(mainWindowHandle);
            }
        }





    }
}
