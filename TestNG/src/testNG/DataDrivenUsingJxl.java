package testNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDrivenUsingJxl {
	
	String [][] data=null;
	
	
	
	@DataProvider(name="Testdata")
	public String[][] logindataprovider() throws BiffException, IOException {
		data=getexceldata();
		return data;
	}

	
	public String[][] getexceldata() throws BiffException, IOException {
	
		FileInputStream excel=new FileInputStream("C:\\Users\\SANKAR\\Desktop\\Book1.xls");
		
		Workbook workbook=Workbook.getWorkbook(excel);
		
		Sheet sheet=workbook.getSheet(0);
		
		int rowcount=sheet.getRows();
		
		int columncount=sheet.getColumns();
		
		String[][] testdata=new String [rowcount-1][columncount];
		
		for(int i=1; i<rowcount;i++) {
			for(int j=0;j<columncount;j++) {
			testdata[i-1][j]=sheet.getCell(j,i).getContents();
			}
			
		}	
		
		return testdata;
}
	
	@Test(dataProvider ="Testdata")
	public void data(String Username,String Password) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\SANKAR\\\\Downloads\\\\chromedriver-win64\\\\chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(6000);
	WebElement username=driver.findElement
		(By.xpath("//*[@name='username']"));

    username.sendKeys(Username);
     WebElement password=driver.findElement(By.xpath("//*[@name='password']"));

      password.sendKeys(Password);

    WebElement submit =driver.findElement(By.xpath("//button[@type='submit']"));
     submit.click();
      Thread.sleep(8000);
       driver.quit();
	}
}