package actionExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CredentialCheckExample {

	WebDriver driver;
	@BeforeTest
	public void launchApp()
	{
		System.out.println("launch bowser");
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	} 
	@AfterTest
	public void closeBrowser() throws Exception
	{
		System.out.println("Close app");
		Thread.sleep(4000);
		driver.close();
	}
	@Test
	public void checkCreadentialFirst() throws Exception{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		Thread.sleep(2000);
	}
	@Test(priority=1)
	public void checkCreadentialSecond() throws Exception{
		driver.findElement(By.id("txtUsername")).sendKeys("");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		Thread.sleep(2000);
	}
	@Test(priority=2)
	public void checkCreadentialThird() throws Exception{
		driver.findElement(By.id("txtUsername")).sendKeys("");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		Thread.sleep(2000);
	}
}
