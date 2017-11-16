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
	       // return getSearchData("D:\\logindata.csv");//获取CSV文件的测试数据  
	    } */
	@Test(dataProvider="loginData")  
	public  void login(String name,String password,String Result)throws InterruptedException{
		
		WebElement package_name = driver.findElement(By.xpath(".//*[@id='myform']/div[1]/div/table/tbody[1]/tr[1]/td[2]/input"));//点资产包名称
		WebElement rzf = driver.findElement(By.xpath(".//*[@id='select2-id_label_multiple-container']"));//融资方
		WebElement fenlei = driver.findElement(By.xpath(".//*[@id='type']"));// 产品分类 
		WebElement jine = driver.findElement(By.xpath(".//*[@id='myform']/div[1]/div/table/tbody[1]/tr[2]/td[4]/input")); //目标募集金额  
		WebElement jixi = driver.findElement(By.xpath(".//*[@id='interest_mode']")); // 计息方式 
		WebElement touziqixian = driver.findElement(By.xpath(".//*[@id='myform']/div[1]/div/table/tbody[1]/tr[3]/td[4]/input")); //  投资期限
		WebElement jixitianshu = driver.findElement(By.xpath(".//*[@id='myform']/div[1]/div/table/tbody[1]/tr[3]/td[8]/input")); // 计息天数基数 
		WebElement jichulilue = driver.findElement(By.xpath(".//*[@id='myform']/div[1]/div/table/tbody[1]/tr[3]/td[8]/input")); //基础利率  
		WebElement faxingfeilu = driver.findElement(By.xpath(".//*[@id='myform']/div[1]/div/table/tbody[1]/tr[4]/td[4]/input")); //  发行费率
		WebElement shouqufangshi = driver.findElement(By.xpath(".//*[@id='issue_fee_mode']")); // 发行费收取方式 
		WebElement shouyilexing = driver.findElement(By.xpath(".//*[@id='annual_income_type']")); //收益类型  
		WebElement huankuanfangshi = driver.findElement(By.xpath(".//*[@id='repay_mode']")); // 还款方式 
		WebElement danbaogongsi = driver.findElement(By.xpath(".//*[@id='guarantee_id']")); //担保公司
		WebElement danbaofangshi = driver.findElement(By.xpath(".//*[@id='myform']/div[1]/div/table/tbody[1]/tr[6]/td[6]/input")); // 担保方式 
		WebElement sale = driver.findElement(By.xpath(".//*[@id='sale']")); // 销售渠道 
		WebElement zxfs = driver.findElement(By.xpath(".//*[@id='tm1']")); // 增信方式 
		WebElement submit = driver.findElement(By.xpath(".//*[@id='myform']/div[1]/div/input[3]"));   //添加
		package_name.sendKeys("lcc003");//点资产包名称
		  String js = "document.querySelectorAll('select')[0].style.display='block';";
	        ((JavascriptExecutor)driver).executeScript(js);
		Select sel = new Select(rzf);//融资方
//		sel.selectByValue("孟庆楼科技有限公司");
		Select sel2 = new Select(fenlei);//产品分类 
		sel.selectByValue("保理");
		jine.sendKeys("1000");//目标募集金额 
		Select sel3 = new Select(jixi);//计息方式 
		sel.selectByIndex(0);
		touziqixian.sendKeys("1");
		jixitianshu.sendKeys("1");
		jichulilue.sendKeys("10");
		faxingfeilu.sendKeys("10");
		Select sel4 = new Select(danbaogongsi);//担保公司
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
	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);//页面超时
	
}
/*
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
} */
}
