package cn.gomeplus;
import javax.lang.model.element.Element;

import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.jetty.html.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class login {
	public static void login_demo() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 String url = "https://www-pre.gomeplus.in/";
		 driver.get(url);
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
		 //元素
		 WebElement login_button = driver.findElement(By.id("signpop"));//登录按钮
		 WebElement register_button = driver.findElement(By.id("regpop"));//注册按钮
		 WebElement mobile =driver.findElement(By.id("mobile"));
		 WebElement smsbtn = driver.findElement(By.className("sendbtn"));
		 WebElement sms =driver.findElement(By.id("sms"));
		 WebElement newpasd =driver.findElement(By.id("newpasd"));
		 WebElement js_register =driver.findElement(By.id("js-register"));
		 WebElement countrycode = driver.findElement(By.className("icon icon-registerdown"));
		 register_button.click();
		 //输入参数
		 countrycode.click();
		 Thread.sleep(2000);
		 
		 mobile.sendKeys("9312620006");
		 smsbtn.click();
		 Thread.sleep(2000);
		 sms.sendKeys("111111");
		 newpasd.sendKeys("wei281410");
		 Thread.sleep(2000);
		 js_register.click();
		 Thread.sleep(2000);
		 //退出
		 driver.quit();
	}


 
 



}
