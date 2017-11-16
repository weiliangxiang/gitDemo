package cn.gomeplus;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
@Test
public class prompt {
	public static void prompt()throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url= "file:///D:/soft/selenium/webdriver/prompt.html";
		driver.get(url);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("wlx");
		alert.accept();
		Thread.sleep(5000);	
	driver.quit();
	}
}
