package cn.gomeplus;

import java.awt.Desktop.Action;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
@Test
public class confirm {
	public static void button_group()throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url= "file:///D:/soft/selenium/webdriver/confirm.html";
		driver.get(url);
	driver.switchTo().alert().dismiss();//accept
	Thread.sleep(5000);
	driver.switchTo().alert().dismiss();
	Thread.sleep(5000);
	driver.quit();
	}
}
