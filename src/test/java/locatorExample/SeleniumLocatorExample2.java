package locatorExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import localExample.BaseTest;

public class SeleniumLocatorExample2 extends BaseTest2{
	WebDriver driver;
	@Test
	public void login() {
		WebElement editbox_User = driver.findElement(By.id("txtUsername"));
		editbox_User.sendKeys("Admin");
		
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}
}
