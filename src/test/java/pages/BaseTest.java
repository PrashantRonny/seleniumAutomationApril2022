package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	LoginPage lp;
	ReadDataFromConfigExample conf;
	@BeforeTest
	public void launchApp() throws Exception
	{
		System.out.println("launch bowser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		conf = new ReadDataFromConfigExample();
	//	System.out.println(conf.getAppURL());
		
		driver.get(conf.getAppURL());
		//driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		
		lp=new LoginPage(driver);
	} 
	@AfterTest
	public void closeBrowser() throws Exception
	{
		System.out.println("Close app");
		Thread.sleep(4000);
		driver.close();
	}
	@AfterMethod
	public void delayAfterEachMethod() throws Exception{
		System.out.println("Exception after each method");
		Thread.sleep(2000);
	}
}
