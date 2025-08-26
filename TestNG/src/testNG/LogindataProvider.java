package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogindataProvider {
	
	
	String[][] data= {
			
			{"Adim","admin123"},
			{"Admin","admin123"},
			{"Admin","asdd"},
			{"asses","asass"},
	};
			
	
	
	@DataProvider(name="Testdata")
	public String[][] loginprovider() {
		return data;
	}
	
	
	@Test(dataProvider ="Testdata")
	public void data(String Username,String Password) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\SANKAR\\\\Downloads\\\\chromedriver-win64\\\\chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(5000);
	
	
	WebElement username=driver.findElement
		(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
	
    username.sendKeys(Username);


     WebElement password=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));


      password.sendKeys(Password);

    WebElement submit =driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
     submit.click();
      Thread.sleep(5000);
       driver.quit();
	
	}	
}
