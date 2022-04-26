package locatorExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazoneSearchTest {

	WebDriver driver;
	@BeforeTest
	public void searchTestCase()
	{
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
	} 
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	
	@Test
	public void login()
	{
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("SmartPhone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
	}
	
}
