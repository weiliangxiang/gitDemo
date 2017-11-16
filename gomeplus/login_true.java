package cn.gomeplus;

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
@Test
public class login_true {
	public static void login_demo() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 String url = "https://www-pre.gomeplus.in/";
		 driver.get(url);
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
		 WebElement signpop = driver.findElement(By.id("signpop"));//��¼��ť
		 WebElement sign_mobile =driver.findElement(By.xpath("//input[@id='sign-mobile']"));//�˺�
		 WebElement sign_password =driver.findElement(By.xpath("//input[@id='sign-password']"));//����
		 WebElement js_sign =driver.findElement(By.id("js-sign"));//�����¼
		// WebElement country_code =driver.findElement(By.xpath("//div[contains(@class,'countrycode')]"));//������Ҵ���(����div��class���԰���coutrycode��ҳ��Ԫ��)
		 WebElement country_code =driver.findElement(By.xpath(".//*[contains(@class,'countrycode')]"));
		//�������
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signpop")));
		 signpop.click();
		 Thread.sleep(2000);
		 country_code.click();
		 Thread.sleep(2000);
		 WebElement chinaElement = driver.findElement(By.xpath(".//*[@id='login-form']/ul/li[1]/div/div[2]/div/div/div[1]/ul/li[35]/span[1]"));//ѡ����Ҵ���
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", chinaElement ); //������chinaElementԪ��
		 chinaElement.click();
		// chinaElement.click();
		 Thread.sleep(9000);
		 sign_mobile.sendKeys("13718905206");
		 sign_password.sendKeys("wei281410");
		 js_sign.click();
		 Thread.sleep(5000);
		 //
		 driver.quit();
		 

		 


	}
	
}











