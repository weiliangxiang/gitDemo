package cn.gomeplus;

import java.util.List;

import mx4j.tools.config.DefaultConfigurationBuilder.New;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.Click;
@Test
public class chandao {
	public static void chandao()throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1/zentao/user-login.html");
		Thread.sleep(2000);
		//Ԫ�ض�λ
		WebElement name = driver.findElement(By.xpath(".//*[@id='account']"));
		WebElement password = driver.findElement(By.xpath(".//*[@name='password']"));
		WebElement submit = driver.findElement(By.xpath(".//*[@id='submit']"));
		
		//WebElement product = driver.findElement(By.xpath(".//*[@text='��Ʒ']"));
		/*
		WebElement e = driver.findElement(By.text(""));
		WebElement e = driver.findElement(By.xpath(""));
		WebElement e = driver.findElement(By.xpath(""));
		*/
		name.sendKeys("admin");
		password.sendKeys("123456");
		submit.click();
		Thread.sleep(2000);
		//driver.switchTo().alert().accept();
		Thread.sleep(2000);
		WebElement product =  driver.findElement(By.linkText("��Ʒ"));
		product.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[@data-id='create']/a")).click();//�����Ӳ�Ʒ
		driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("a16");//��Ʒ����
		driver.findElement(By.xpath(".//*[@id='code']")).sendKeys("b16");//��Ʒ����
		//��Ʒ������
		  	String js = "document.querySelectorAll('select')[0].style.display='block';";
	        ((JavascriptExecutor)driver).executeScript(js);
	        Select select = new Select(driver.findElement(By.xpath("//select[@id='PO']")));
	        select.selectByIndex(2);
	       //���Ը�����
	       driver.findElement(By.xpath(".//*[@id='QD_chosen']/a")).click();
	       driver.findElement(By.xpath(".//*[@id='QD_chosen']/div/ul/li[1]")).click();
	        //����������
	       driver.findElement(By.xpath(".//*[@id='RD_chosen']/a")).click();
	       driver.findElement(By.xpath(".//*[@id='RD_chosen']/div/ul/li[1]")).click();
	        //��Ʒ����
	        Select select4 = new Select(driver.findElement(By.xpath(".//*[@id='type']")));
	        select4.selectByIndex(0);
	        Thread.sleep(2000); 
		driver.findElement(By.xpath(".//*[@id='submit']")).click();//���水ť
		Thread.sleep(2000);
		driver.findElement(By.linkText("��Ŀ")).click();
		Thread.sleep(1000); 
		driver.findElement(By.linkText("Bug")).click();
		Thread.sleep(1000); 
		driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("name1");//��Ŀ����
		driver.findElement(By.xpath(".//*[@id='code']")).sendKeys("code1");//��Ŀ����
		driver.findElement(By.xpath(".//*[@id='begin']")).sendKeys("2017-05-24");//���ù�����
		driver.findElement(By.xpath(".//*[@id='end']")).sendKeys("2017-05-25");	//
		driver.findElement(By.xpath(".//*[@id='dataform']//label[1]")).click();
		driver.findElement(By.xpath(".//*[@id='days']")).sendKeys("5");//���ù�����
		driver.findElement(By.xpath(".//*[@id='team']")).sendKeys("�Ŷ�����1");//�Ŷ�����
		Select sel= new Select(driver.findElement(By.xpath(".//*[@id='type']")));//��Ŀ����
		/*
		((JavascriptExecutor)driver).executeScript("document.querySelectorAll('select')[0].style.display='block';");
		Select select5 = new Select(driver.findElement(By.xpath("//select[@id='products0']")));//������Ʒ
		select5.selectByIndex(1);*/
		driver.findElement(By.xpath(".//*[@id='submit']")).click();//
		driver.quit();
	}

}
