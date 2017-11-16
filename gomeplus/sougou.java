package cn.gomeplus;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class sougou {
	private static WebDriver driver;  
    @DataProvider(name="searchData")  
    public static Object[][] data() throws IOException  
    {  
        return getSearchData("E:\\AutoData\\","testData.xlsx","testData");//��ȡExcel�ļ��Ĳ�������  
    }  
  @Test(dataProvider="searchData")  
  public void testSearch(String searchdata1,String searchdata2,String searchResult) {  
      //��sogou��ҳ  
      driver.get("http://www.sogou.com/");  
      //������������  
      //��Excel�ļ��ж�ȡÿ����ǰ2����Ԫ��������Ϊ������������������ؼ���,�������������м�����һ���ո�  
      driver.findElement(By.id("query")).sendKeys(searchdata1+" "+searchdata2);  
      //����������ť  
      driver.findElement(By.id("stb")).click();  
        
      //ʹ����ʽ�ȴ���ʽ��ȷ��ҳ���Ѿ�������ɣ�ҳ��ײ��Ĺؼ���"��������"�Ѿ���ʾ��ҳ����  
      (new WebDriverWait(driver,3)).until(new ExpectedCondition<Boolean>(){  
  
        @Override  
        public Boolean apply(WebDriver d) {  
            return d.findElement(By.id("sogou_webhelp")).getText().contains("��������");  
        }});  
  
      //�����������ҳ���Ƿ����Excel�ļ���ÿ�е����һ����Ԫ�����ݵĹؼ���  
      Assert.assertTrue(driver.getPageSource().contains(searchResult));  
  }  
  @BeforeMethod  
  public void beforeMethod() {  
      //���޷���Firefox����������趨Firefox������İ�װ·��  
	  System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver.exe");
      //��Firefox�����  
      driver=new ChromeDriver();  
      //�趨�ȴ�ʱ��Ϊ5��  
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  
  }  
  
  @AfterMethod  
  public void afterMethod() throws InterruptedException {  
	  Thread.sleep(9000);
      //�رմ򿪵������  
      driver.quit();  
  }  
  //��Excel�ļ���ȡ�������ݵľ�̬����  
  public static Object[][] getSearchData(String filePath,String FileName,String sheetName) throws IOException{  
        //���ݲ�������������ļ�·�����ļ����ƣ���ϳ�Excel�����ļ��ľ���·��������һ��File�ļ�����  
        File file = new File(filePath + "\\" + FileName);  
        //����FileInputStream�������ڶ�ȡExcel�ļ�  
        FileInputStream inputStream = new FileInputStream(file);  
        Workbook Workbook = null;  
        //��ȡ�ļ�����������չ�����ж���.xlsx�ļ�����.xls�ļ�  
        String fileExtensionName = FileName.substring(FileName  
                .indexOf("."));  
        if (fileExtensionName.equals(".xlsx")) {   
            Workbook = new XSSFWorkbook(inputStream);
        } else if (fileExtensionName.equals(".xls")) {  
            Workbook = new HSSFWorkbook(inputStream);  
        }  
        //ͨ��sheetName����������Sheet����  
        Sheet Sheet = Workbook.getSheet(sheetName);  
        //��ȡExcel�����ļ�Sheet1�����ݵ�������getLastRowNum()������ȡ���ݵ����һ���к�  
        //getFirstRowNum()������ȡ���ݵĵ�һ���кţ����֮��ó����ݵ�������Excel�ļ����кź��кŶ��Ǵ�0��ʼ  
        int rowCount = Sheet.getLastRowNum() - Sheet.getFirstRowNum();  
        //����list����洢��Excel�����ļ���ȡ������  
        List<Object[]> records = new ArrayList<Object[]>();  
        //ѭ������Excel�����ļ����������ݣ����˵�һ�У���һ��������������  
        for (int i = 1; i < rowCount + 1; i++) {  
            //ʹ��getShow������ȡ�ж���  
            Row row = Sheet.getRow(i);  
            //����һ�����飬�洢Excel�����ļ�ÿ���е�3�����ݣ�����Ĵ�С��getLastCellNum()�������ж�̬������ʵ�ֲ������ݸ����������Сһ��  
            String fields[] = new String[row.getLastCellNum()];  
            for (int j = 0; j < row.getLastCellNum(); j++) {  
                //ʹ��getCell()��getStringCellValue()������ȡExcel�ļ��еĵ�Ԫ������  
                fields[j] =row.getCell(j).getStringCellValue();  
            }  
            //��fields�����ݶ������records��list��  
            records.add(fields);  
        }  
        // ���洢�������ݵ�Listת��Ϊһ��Object�Ķ�ά����  
        Object[][] results = new Object[records.size()][];  
        // ���ö�λ����ÿ�е�ֵ��ÿ����һ��Object����  
        for (int i = 0; i < records.size(); i++) {  
            results[i] = records.get(i);  
        }  
        return results;  
  }  

}
