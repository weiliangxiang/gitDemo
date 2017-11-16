package cn.gomeplus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
@Test
public class location3 {
	public static void level_location() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/soft/selenium/webdriver/level-location.html");
		driver.findElement(By.xpath("//ul[@id='dropdown2']")).findElement(By.linkText("Another action")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}
