package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ClassFiles.Credentials;
import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
//import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import junit.framework.Assert;

public class Test_Steps 
{
	public static WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Given("^User launches amazon site$")
	public void user_launches_amazon_site() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
	    System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\Cucumber Setup\\Drivers\\chromedriver_win32\\chromedriver.exe");  
	       
        // Instantiate a ChromeDriver class.     
	    driver=new ChromeDriver(); 
	    
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get("https://www.amazon.in/");
	}

	@Given("^User enters username and password$")
	public void user_enters_username_and_password() throws Throwable 
	{
		
		driver.findElement(By.id("nav-link-accountList")).click();			
		
		Thread.sleep(5000);		
		
		driver.findElement(By.id("ap_email")).sendKeys("9962986991");
		
		//driver.findElement(By.id("continue")).click();
		
		WebElement _continue = driver.findElement(By.id("continue"));		
		js.executeScript("arguments[0].click();", _continue);
		
		driver.findElement(By.id("ap_password")).sendKeys("yuvin2020");		
	    
	}
	
	public void BorderElement(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	@Given("^User enters username \"(.*?)\" and password \"(.*?)\"$")
	public void user_enters_username_and_password(String userName, String password) throws Throwable 
	{
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.id("ap_email")).sendKeys(userName);
		Thread.sleep(5000);
		driver.findElement(By.id("ap_email")).clear();
		driver.findElement(By.id("ap_email")).sendKeys(userName);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys(password);	
	    
	}
	
	@Given("^User enters invalid \"(.*?)\" and click on continue$")
	public void user_enters_invalid_and_click_on_continue(String userName) throws Throwable {
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.id("ap_email")).sendKeys(userName);
		Thread.sleep(3000);
		driver.findElement(By.id("continue")).click();
		System.out.println("Data table used for input");
	}


	@When("^User clicks on sign in button$")
	public void user_clicks_on_sign_in_button() throws Throwable 
	{
	    driver.findElement(By.id("signInSubmit")).click();  
	    //driver.close();
	}
	
	@Given("^User enters invalid username and click on continue$")
	public void user_enters_invalid_username_and_click_on_continue() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.id("ap_email")).sendKeys("9962986992");
		driver.findElement(By.id("continue")).click();
	}

	@When("^User verifies username is invalid$")
	public void user_verifies_username_is_invalid() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    WebElement text = driver.findElement(By.xpath("//*[contains(text(), 'Incorrect phone number')]"));
	    org.junit.Assert.assertEquals("Incorrect phone number", text.getText());
		driver.findElement(By.id("createAccountSubmit")).click();
	    
	    //driver.close();
		//driver.quit();
	    
	}	

	
	@Given("^User enters username and password using data table$")
	public void user_enters_username_and_password_using_data_table(DataTable usercredentials) throws Throwable 
	{

		driver.findElement(By.id("nav-link-accountList")).click();
		List<List<String>> data = usercredentials.raw();
		driver.findElement(By.id("ap_email")).sendKeys(data.get(0).get(0));
		Thread.sleep(5000);
		driver.findElement(By.id("ap_email")).clear();
		driver.findElement(By.id("ap_email")).sendKeys(data.get(0).get(0));
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys(data.get(0).get(1));
	}
	
	@Given("^User enters username and password using data table mapping$")
	public void user_enters_username_and_password_using_data_table_mapping(DataTable usercredentials) throws Throwable 
	{

		driver.findElement(By.id("nav-link-accountList")).click();
		List<Map<String,String>> data = usercredentials.asMaps(String.class,String.class);
	    driver.findElement(By.id("ap_email")).sendKeys(data.get(0).get("username")); 
		driver.findElement(By.id("continue")).click();
		Thread.sleep(5000);
	    driver.findElement(By.id("ap_password")).sendKeys(data.get(0).get("password"));
	}
	
	@Given("^User enters username and password using data table and object class$")
	public void user_enters_username_and_password_using_data_table_and_object_class(List<Credentials>  usercredentials) throws Throwable 
	{
		for (Credentials credentials : usercredentials) 
		{ 
			driver.findElement(By.id("nav-link-accountList")).click();
			driver.findElement(By.id("ap_email")).sendKeys(credentials.getUsername()); 
			driver.findElement(By.id("continue")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("ap_password")).sendKeys(credentials.getPassword());
		}
	}
	
	public void DrawBorder(WebElement element, WebDriver driver)
	{
		
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
}
