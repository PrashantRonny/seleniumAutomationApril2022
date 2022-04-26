package takeScreenshortExample;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazoneSearchTest {

	WebDriver driver;
	@BeforeTest
	public void searchTestCase()
	{
		System.out.println("launch bowser");
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
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
	public void searchItems() throws Exception
	{
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("iphone");
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
		
		Thread.sleep(4000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File targetLocation = new File("C:\\Users\\prash\\eclipse-workspace\\com.coforge_Training.selenium\\ScreenSot/AmazoneTest_iphone2.png");
		
		FileUtils.copyFile(screenshotFile,targetLocation);
	}
	
	@Test(priority = 1)
	public void verifyAppTitle() {
		String actualAppTitle = driver.getTitle();
		String expectedTitle = "Amazon.in : iphone";
		
		//validation step
		Assert.assertEquals(actualAppTitle, expectedTitle);
	}
	
}
