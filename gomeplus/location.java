package cn.gomeplus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
@Test
public class location {
	public static void location() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 String url = "https://hao.360.cn/";
		 driver.get(url);
		// <a class="tab-item news" data-page="http://sh.qihoo.com/daohang/index1.html" hidefocus="false"href="./brother.html#!news">新闻头条</a>
		 WebElement newsElement=driver.findElement(By.linkText("新闻头条"));       //定位新闻头条
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.className("news"))).click();

	}
	

}
