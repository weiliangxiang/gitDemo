package cn.gomeplus;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import bsh.commands.dir;
@Test
public class product {
	public static void login_demo() throws InterruptedException{
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		// JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		 String url = "https://www-pre.gomeplus.in/";
		 driver.get(url);
		 //driver.manage().window().maximize();
		Thread.sleep(2000);
		//WebElement more = driver.findElement(By.xpath("html/body/div[3]/div[1]/div[1]/ul/a[7]/li"));
		List<WebElement> leftmunes = driver.findElements(By.xpath("//span[@class='leftnavtext']"));
		for(WebElement lefttext:leftmunes){
			System.out.println(lefttext.getText());
		}
		WebElement moreElement = driver.findElement(By.xpath("//li[@class='text-gray']"));
		moreElement.click();
		/*
		more.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[3]/div[2]/div[2]/div[1]/div[1]/a/h2")));//显示等待商品标题
		driver.findElement(By.xpath("html/body/div[3]/div[2]/div[2]/div[1]/div[1]/a/h2")).click();//点击商品标题
		Thread.sleep(2000);
		jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");//滚动条拖到底部
		Thread.sleep(5000);
		jsExecutor.executeScript("window.scrollTo(0,0)");//滚动条拖到顶部
		*/
		driver.quit();
		
	}
}
