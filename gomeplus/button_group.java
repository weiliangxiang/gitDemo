package cn.gomeplus;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
@Test
public class button_group {
	public static void button_group()throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url= "file:///D:/soft/selenium/webdriver/button%20group.html";
		driver.get(url);
		List<WebElement> btns = driver.findElement(By.xpath("//div[@class='btn-group']")).findElements(By.className("btn"));
		for(WebElement btn:btns){
		System.out.println(btn.getText());
		if(btn.getText().equals("second")){
			btn.click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
		}
		}
		Thread.sleep(5000);/*
		1.弹出框尝试enter键输入无效
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER);*/
		driver.switchTo().alert().accept();
		Thread.sleep(2000);	
	driver.quit();
	}
}
