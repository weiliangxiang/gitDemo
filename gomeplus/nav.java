package cn.gomeplus;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
@Test
public class nav {
	public static void nav()throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url= "file:///D:/soft/selenium/webdriver/navs.html";
		driver.get(url);
		List<WebElement> navs = driver.findElements(By.xpath("nav").tagName("a"));
		for(WebElement nav:navs){
			System.out.println(nav.getText());
		}
	}
}
