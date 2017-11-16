package cn.gomeplus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
@Test
public class select {
	public static void select_demo()throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url= "file:///D:/soft/selenium/webdriver/select.html";
		driver.get(url);
	Select select = new Select(driver.findElement(By.xpath("//select[@name='fruits']")));
	select.selectByIndex(0);
	Thread.sleep(2000);
	select.selectByValue("Apple");
	Thread.sleep(2000);
	select.selectByVisibleText("Orange");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@type='reset']")).click();
	Thread.sleep(2000);
	driver.quit();
	}

}
