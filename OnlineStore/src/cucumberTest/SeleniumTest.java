package cucumberTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;  
 
public class SeleniumTest 
{
 
 public static void main(String[] args) throws InterruptedException {
 // Create a new instance of the Firefox driver
 
	 
	     System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Cucumber Setup\\Drivers\\chromedriver_win32\\chromedriver.exe");  
	     // Instantiate a ChromeDriver class.     
	     WebDriver driver=new ChromeDriver();

	     driver.navigate().to("http://www.javatpoint.com/"); 
		 driver.manage().window().maximize(); 
		 Thread.sleep(5000);   
	     driver.findElement(By.linkText("Core Java")).click();     
	     
	     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	     driver.get("https://www.amazon.in/");
		 driver.findElement(By.id("nav-link-accountList")).click();
		 driver.findElement(By.id("ap_email")).sendKeys("9962986991");
		 driver.findElement(By.id("continue")).click();
		 driver.findElement(By.id("ap_password")).sendKeys("yuvin2020");
		 driver.findElement(By.id("signInSubmit")).click();
	  
	     //driver.quit();	        
	     //driver.close();	 
 }
 
}