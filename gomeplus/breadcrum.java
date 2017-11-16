package cn.gomeplus;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.testng.annotations.Test;
@Test
public class breadcrum {
	public static void button_group()throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url= "file:///D:/soft/selenium/webdriver/bread.html";
		driver.get(url);
		List<WebElement> breadcrumbs = driver.findElements(By.xpath("//ul[@class='breadcrumb']"));
		for(WebElement bread:breadcrumbs){
			WebElement activeElement = driver.findElement(By.xpath("li[@class='active']"));
			System.out.println(bread.getText());
		}
	
	}
}
