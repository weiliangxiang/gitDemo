package cn.gomeplus;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
@Test
public class location2 {
	public static void location2() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 String url = "file:///D:/soft/selenium/webdriver/location.html";
		 String url2 = "file:///D:/soft/selenium/webdriver/location.html?emali=123&password=";
		 driver.get(url);
		 driver.findElement(By.xpath("//input[@id='loginemail']")).sendKeys("123");//输入用户名
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("456");//输入用户名
		 driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@id='sgn']")).click();//点击提交
		 Thread.sleep(5000);
		 driver.findElement(By.linkText("register")).click();
		 Thread.sleep(2000);
		 driver.quit();

	}
}
