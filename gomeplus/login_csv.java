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
	        return getSearchData("D:\\logindata.csv");//��ȡCSV�ļ��Ĳ�������  
	    } 
	@Test(dataProvider="loginData")  
	public  void login(String name,String password,String Result)throws InterruptedException{
		
		WebElement countrycode = driver.findElement(By.xpath("//div[@class='countrycode']"));//���codecountry
		List<WebElement> listweElements = driver.findElements(By.xpath("scroll_absolute"));
		for(WebElement listElement:listweElements){
			System.out.println(listElement.getText());
		}
		WebElement login_button = driver.findElement(By.id("signpop"));//��¼��ť
		 WebElement sign_mobile =driver.findElement(By.xpath("//input[@id='sign-mobile']"));//�˺�
		 WebElement sign_password =driver.findElement(By.xpath("//input[@id='sign-password']"));//����
		 WebElement js_sign =driver.findElement(By.id("js-sign"));//�����¼
		 login_button.click();
		 countrycode.click();
		 
		 sign_mobile.sendKeys(name);
		 sign_password.sendKeys(password);
		 Thread.sleep(5000);
		 js_sign.click();
	      //�����������ҳ���Ƿ����CSV�ļ���ÿ�е����һ���ʻ�Ĺؼ���  
	      Assert.assertTrue(driver.getPageSource().contains(Result)); 
	      driver.navigate().refresh();
	      Thread.sleep(5000);
	}
@BeforeClass
public  void beforeMethod(){
	System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.get("https://www.gomeplus.in/");
	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);//ҳ�泬ʱ
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signpop")));
	
}
@AfterClass
public  void afterMethod(){
	driver.quit();
}
//��ȡCSV�ļ��ľ�̬������ʹ��CSV�ļ��ľ����ļ�·����Ϊ��������  
public static Object[][] getSearchData(String FileNameroot) throws IOException{  
    List<Object[]> records=new ArrayList<Object[]>();  
    String record;  
    //�趨UTF-8�ַ�����ʹ�ô����������ַ�������BufferedReader��ȡ�ļ�����  
    BufferedReader file=new BufferedReader(new InputStreamReader(new FileInputStream(FileNameroot),"UTF-8"));  
    //���Զ�ȡCSV�ļ��ı����У���һ�У�  
    file.readLine();  
    //������ȡ�ļ��г���һ����������������ݲ��洢����Ϊrecords��ArrayList�У�ÿһ��records�д洢�Ķ���Ϊһ��String����  
    while((record=file.readLine())!=null){  
        String fields[]=record.split(",");  
        records.add(fields);  
    }  
    //�ر��ļ�����  
    file.close();  
    //���洢�������ݵ�Listת��Ϊһ��Object�Ķ�ά����  
    Object[][] results=new Object[records.size()][];  
    //���ö�λ����ÿ�е�ֵ��ÿ����һ��Object����  
    for(int i=0;i<records.size();i++){  
        results[i]=records.get(i);  
    }  
    return results;       
} 
}
