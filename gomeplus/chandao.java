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
		//元素定位
		WebElement name = driver.findElement(By.xpath(".//*[@id='account']"));
		WebElement password = driver.findElement(By.xpath(".//*[@name='password']"));
		WebElement submit = driver.findElement(By.xpath(".//*[@id='submit']"));
		
		//WebElement product = driver.findElement(By.xpath(".//*[@text='产品']"));
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
		WebElement product =  driver.findElement(By.linkText("产品"));
		product.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[@data-id='create']/a")).click();//点击添加产品
		driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("a16");//产品名称
		driver.findElement(By.xpath(".//*[@id='code']")).sendKeys("b16");//产品代号
		//产品负责人
		  	String js = "document.querySelectorAll('select')[0].style.display='block';";
	        ((JavascriptExecutor)driver).executeScript(js);
	        Select select = new Select(driver.findElement(By.xpath("//select[@id='PO']")));
	        select.selectByIndex(2);
	       //测试负责人
	       driver.findElement(By.xpath(".//*[@id='QD_chosen']/a")).click();
	       driver.findElement(By.xpath(".//*[@id='QD_chosen']/div/ul/li[1]")).click();
	        //发布负责人
	       driver.findElement(By.xpath(".//*[@id='RD_chosen']/a")).click();
	       driver.findElement(By.xpath(".//*[@id='RD_chosen']/div/ul/li[1]")).click();
	        //产品类型
	        Select select4 = new Select(driver.findElement(By.xpath(".//*[@id='type']")));
	        select4.selectByIndex(0);
	        Thread.sleep(2000); 
		driver.findElement(By.xpath(".//*[@id='submit']")).click();//保存按钮
		Thread.sleep(2000);
		driver.findElement(By.linkText("项目")).click();
		Thread.sleep(1000); 
		driver.findElement(By.linkText("Bug")).click();
		Thread.sleep(1000); 
		driver.findElement(By.xpath(".//*[@id='name']")).sendKeys("name1");//项目名称
		driver.findElement(By.xpath(".//*[@id='code']")).sendKeys("code1");//项目代号
		driver.findElement(By.xpath(".//*[@id='begin']")).sendKeys("2017-05-24");//可用工作日
		driver.findElement(By.xpath(".//*[@id='end']")).sendKeys("2017-05-25");	//
		driver.findElement(By.xpath(".//*[@id='dataform']//label[1]")).click();
		driver.findElement(By.xpath(".//*[@id='days']")).sendKeys("5");//可用工作日
		driver.findElement(By.xpath(".//*[@id='team']")).sendKeys("团队名称1");//团队名称
		Select sel= new Select(driver.findElement(By.xpath(".//*[@id='type']")));//项目类型
		/*
		((JavascriptExecutor)driver).executeScript("document.querySelectorAll('select')[0].style.display='block';");
		Select select5 = new Select(driver.findElement(By.xpath("//select[@id='products0']")));//关联产品
		select5.selectByIndex(1);*/
		driver.findElement(By.xpath(".//*[@id='submit']")).click();//
		driver.quit();
	}

}
