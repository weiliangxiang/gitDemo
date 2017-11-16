package cn.gomeplus;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class review {
	@Test
public static void review() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 String url = "https://www.gomeplus.in/";
		 driver.get(url);
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
		 WebElement signpop = driver.findElement(By.id("signpop"));//登录按钮
		 WebElement sign_mobile =driver.findElement(By.xpath("//input[@id='sign-mobile']"));//账号
		 WebElement sign_password =driver.findElement(By.xpath("//input[@id='sign-password']"));//密码
		 WebElement js_sign =driver.findElement(By.id("js-sign"));//点击登录
		 
		//输入参数
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signpop")));
		 signpop.click();
		 Thread.sleep(2000);
		 WebElement country_code =driver.findElement(By.xpath("//*[@id='login-form']/ul/li[1]/div"));
		 country_code.click();
		 Thread.sleep(2000);
		 List<WebElement> country_code_lists = driver.findElements(By.xpath("//class='scroll_absolute'"));
		 for(WebElement country_code1:country_code_lists){
			 country_code1.getText();
		 }
		 //WebElement chinaElement = driver.findElement(By.xpath(".//*[@id='login-form']/ul/li[1]/div/div[2]/div/div/div[1]/ul/li[35]/span[1]"));//选择国家代码
		 //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", chinaElement ); //下拉到chinaElement元素
		 //chinaElement.click();
		// chinaElement.click();
		 /*
		 Thread.sleep(9000);
		 sign_mobile.sendKeys("13718905206");
		 sign_password.sendKeys("wei281410");
		 js_sign.click();
		 Thread.sleep(5000);
		 //*/
		 driver.quit();
		 

		 


	}
}
