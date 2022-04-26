package locatorExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest2 {

	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
		System.out.println("Launch Browser-app");
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/login.php/");
		driver.manage().window().maximize();
	}
	@AfterTest
	public void closeApp() throws Exception{
		System.out.println("Closing Browser");
		Thread.sleep(4000);
		driver.close();
	}
}
