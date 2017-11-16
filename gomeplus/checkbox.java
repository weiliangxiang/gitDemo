package cn.gomeplus;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
@Test
public class checkbox {
	public static void checkbox()throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url= "file:///D:/soft/selenium/webdriver/elements.html";
		driver.get(url);
		List<WebElement> navs = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(WebElement nav:navs){
		nav.click();
		}
		driver.findElement(By.xpath("//input[@id='r']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
