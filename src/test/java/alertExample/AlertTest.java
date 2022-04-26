package alertExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertTest {

	WebDriver driver;
	@BeforeTest
	public void launchApp()
	{
		System.out.println("launch bowser");
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://only-testing-blog.blogspot.com/2013/11/new-test.html");
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
	public void simpleAlert() throws Exception{
		
		driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
		Thread.sleep(4000);
		Alert ele_simpleAlert = driver.switchTo().alert();
		System.out.println(ele_simpleAlert.getText());
		ele_simpleAlert.dismiss();
	}
	@Test(priority=1)
	public void confirmAlert() throws Exception{
		System.out.println("this is it");
		driver.findElement(By.xpath("//button[text()='Show Me Confirmation']")).click();
		Thread.sleep(4000);
		Alert ele_confirmAlert = driver.switchTo().alert();
		System.out.println(ele_confirmAlert.getText());
		ele_confirmAlert.accept();
		String youPressedOK = driver.findElement(By.cssSelector("div#demo")).getText();
		System.out.println(youPressedOK);
		Assert.assertTrue(youPressedOK.contains("OK"));
	}
}
