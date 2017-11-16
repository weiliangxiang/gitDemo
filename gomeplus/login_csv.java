package cn.gomeplus;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class login_csv {
	public static WebDriver driver;
	
	  @DataProvider(name="loginData")  
	    public static Object[][] data() throws IOException  
	    {  
	        return getSearchData("D:\\logindata.csv");//获取CSV文件的测试数据  
	    } 
	@Test(dataProvider="loginData")  
	public  void login(String name,String password,String Result)throws InterruptedException{
		
		WebElement countrycode = driver.findElement(By.xpath("//div[@class='countrycode']"));//点击codecountry
		List<WebElement> listweElements = driver.findElements(By.xpath("scroll_absolute"));
		for(WebElement listElement:listweElements){
			System.out.println(listElement.getText());
		}
		WebElement login_button = driver.findElement(By.id("signpop"));//登录按钮
		 WebElement sign_mobile =driver.findElement(By.xpath("//input[@id='sign-mobile']"));//账号
		 WebElement sign_password =driver.findElement(By.xpath("//input[@id='sign-password']"));//密码
		 WebElement js_sign =driver.findElement(By.id("js-sign"));//点击登录
		 login_button.click();
		 countrycode.click();
		 
		 sign_mobile.sendKeys(name);
		 sign_password.sendKeys(password);
		 Thread.sleep(5000);
		 js_sign.click();
	      //断言搜索结果页面是否包含CSV文件中每行的最后一个词汇的关键字  
	      Assert.assertTrue(driver.getPageSource().contains(Result)); 
	      driver.navigate().refresh();
	      Thread.sleep(5000);
	}
@BeforeClass
public  void beforeMethod(){
	System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.get("https://www.gomeplus.in/");
	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);//页面超时
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signpop")));
	
}
@AfterClass
public  void afterMethod(){
	driver.quit();
}
//读取CSV文件的静态方法，使用CSV文件的绝对文件路径作为函数参数  
public static Object[][] getSearchData(String FileNameroot) throws IOException{  
    List<Object[]> records=new ArrayList<Object[]>();  
    String record;  
    //设定UTF-8字符集，使用带缓冲区的字符输入流BufferedReader读取文件内容  
    BufferedReader file=new BufferedReader(new InputStreamReader(new FileInputStream(FileNameroot),"UTF-8"));  
    //忽略读取CSV文件的标题行（第一行）  
    file.readLine();  
    //遍历读取文件中除第一行外的其他所有内容并存储在名为records的ArrayList中，每一行records中存储的对象为一个String数组  
    while((record=file.readLine())!=null){  
        String fields[]=record.split(",");  
        records.add(fields);  
    }  
    //关闭文件对象  
    file.close();  
    //将存储测试数据的List转换为一个Object的二维数组  
    Object[][] results=new Object[records.size()][];  
    //设置二位数组每行的值，每行是一个Object对象  
    for(int i=0;i<records.size();i++){  
        results[i]=records.get(i);  
    }  
    return results;       
} 
}
