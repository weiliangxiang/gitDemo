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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class lcc {
	public static WebDriver driver;
	
	  @DataProvider(name="loginData")  
	  /*
	    public static Object[][] data() throws IOException  
	    {  
	       // return getSearchData("D:\\logindata.csv");//��ȡCSV�ļ��Ĳ�������  
	    } */
	@Test(dataProvider="loginData")  
	public  void login(String name,String password,String Result)throws InterruptedException{
		
		WebElement package_name = driver.findElement(By.xpath(".//*[@id='myform']/div[1]/div/table/tbody[1]/tr[1]/td[2]/input"));//���ʲ�������
		WebElement rzf = driver.findElement(By.xpath(".//*[@id='select2-id_label_multiple-container']"));//���ʷ�
		WebElement fenlei = driver.findElement(By.xpath(".//*[@id='type']"));// ��Ʒ���� 
		WebElement jine = driver.findElement(By.xpath(".//*[@id='myform']/div[1]/div/table/tbody[1]/tr[2]/td[4]/input")); //Ŀ��ļ�����  
		WebElement jixi = driver.findElement(By.xpath(".//*[@id='interest_mode']")); // ��Ϣ��ʽ 
		WebElement touziqixian = driver.findElement(By.xpath(".//*[@id='myform']/div[1]/div/table/tbody[1]/tr[3]/td[4]/input")); //  Ͷ������
		WebElement jixitianshu = driver.findElement(By.xpath(".//*[@id='myform']/div[1]/div/table/tbody[1]/tr[3]/td[8]/input")); // ��Ϣ�������� 
		WebElement jichulilue = driver.findElement(By.xpath(".//*[@id='myform']/div[1]/div/table/tbody[1]/tr[3]/td[8]/input")); //��������  
		WebElement faxingfeilu = driver.findElement(By.xpath(".//*[@id='myform']/div[1]/div/table/tbody[1]/tr[4]/td[4]/input")); //  ���з���
		WebElement shouqufangshi = driver.findElement(By.xpath(".//*[@id='issue_fee_mode']")); // ���з���ȡ��ʽ 
		WebElement shouyilexing = driver.findElement(By.xpath(".//*[@id='annual_income_type']")); //��������  
		WebElement huankuanfangshi = driver.findElement(By.xpath(".//*[@id='repay_mode']")); // ���ʽ 
		WebElement danbaogongsi = driver.findElement(By.xpath(".//*[@id='guarantee_id']")); //������˾
		WebElement danbaofangshi = driver.findElement(By.xpath(".//*[@id='myform']/div[1]/div/table/tbody[1]/tr[6]/td[6]/input")); // ������ʽ 
		WebElement sale = driver.findElement(By.xpath(".//*[@id='sale']")); // �������� 
		WebElement zxfs = driver.findElement(By.xpath(".//*[@id='tm1']")); // ���ŷ�ʽ 
		WebElement submit = driver.findElement(By.xpath(".//*[@id='myform']/div[1]/div/input[3]"));   //���
		package_name.sendKeys("lcc003");//���ʲ�������
		  String js = "document.querySelectorAll('select')[0].style.display='block';";
	        ((JavascriptExecutor)driver).executeScript(js);
		Select sel = new Select(rzf);//���ʷ�
//		sel.selectByValue("����¥�Ƽ����޹�˾");
		Select sel2 = new Select(fenlei);//��Ʒ���� 
		sel.selectByValue("����");
		jine.sendKeys("1000");//Ŀ��ļ����� 
		Select sel3 = new Select(jixi);//��Ϣ��ʽ 
		sel.selectByIndex(0);
		touziqixian.sendKeys("1");
		jixitianshu.sendKeys("1");
		jichulilue.sendKeys("10");
		faxingfeilu.sendKeys("10");
		Select sel4 = new Select(danbaogongsi);//������˾
		sel.selectByIndex(0);
		sale.click();
		zxfs.click();
		submit.click();
		driver.quit();
	}
	
@BeforeClass
public  void beforeMethod(){
	System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.get("https://depxboss.jbw666.com/public/login");
	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);//ҳ�泬ʱ
	
}
/*
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
} */
}
