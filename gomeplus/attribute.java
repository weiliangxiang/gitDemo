package cn.gomeplus;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.GetAttribute;
@Test
public class attribute {
	public static void attribute()throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url= "file:///D:/soft/selenium/webdriver/attribute.html";
		driver.get(url);
		System.out.println(driver.findElement(By.id("tooltip")).getAttribute("title"));
	}
}
