package locatorExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMSearch {

	WebDriver driver;
	@BeforeTest
	public void searchTestCase()
	{
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/login.php/");
	} 
	
	
	@Test
	public void login() throws Exception {
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		String actualAttributeLogin = driver.findElement(By.className("button")).getAttribute("value");
		System.out.println("Actual Value: "+ actualAttributeLogin);
		driver.findElement(By.className("button")).click();
		
		Thread.sleep(2000);
		String actualDashLable = driver.findElement(By.tagName("h1")).getText();
		System.out.println("Lable Text are: "+ actualDashLable);
		
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Welcome")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.linkText("Logout")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='button']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Forgot your pass")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[value='Cancel']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("your passw")).click();
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
}
