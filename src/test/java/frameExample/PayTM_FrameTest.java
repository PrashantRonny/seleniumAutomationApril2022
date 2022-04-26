package frameExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PayTM_FrameTest {
	WebDriver driver;
	@BeforeTest
	public void launchApp()
	{
		System.out.println("launch bowser");
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://paytm.com/");
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
	public void promptAlert() throws Exception{
		driver.findElement(By.xpath("//div[@class='_3T0pf']//div[1]")).click();	
		Thread.sleep(4000);
		//switch to frame
		driver.switchTo().frame(0);
		//watch video
		driver.findElement(By.xpath("//span[@class='ng-scope']")).click();
		//Thread.sleep(2000);
		String toLoginInto = driver.findElement(By.className("heading")).getText();
		System.out.println(toLoginInto);
		//validation step
		Assert.assertEquals(toLoginInto, "To Login into your Paytm Web account");
		Assert.assertTrue(toLoginInto.contains("Paytm Web account"));
	}
}
