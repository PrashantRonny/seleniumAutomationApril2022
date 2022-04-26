package actionExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDropTest {
	WebDriver driver;
	@BeforeTest
	public void launchApp()
	{
		System.out.println("launch bowser");
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
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
	public void promptAlert() throws Exception {
		//Multiple frame
		
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frame);
		WebElement drag = driver.findElement(By.id("draggable"));
		Thread.sleep(2000);
		WebElement drop = driver.findElement(By.id("droppable"));
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.dragAndDrop(drag, drop).perform();
		
	}
}
