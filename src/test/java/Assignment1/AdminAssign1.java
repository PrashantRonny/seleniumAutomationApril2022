package Assignment1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AdminAssign1 extends BaseTestAssign1 {
		
	@Test
	public void searchItem() throws Exception
	{
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		driver.findElement(By.name("Password")).clear();
		driver.findElement(By.name("Password")).sendKeys("admin");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.cssSelector("html>body>div:nth-of-type(3)>aside>div>div:nth-of-type(4)>div>div>nav>ul>li:nth-of-type(4)>a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@href='/Admin/Customer/List']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("div#navbarText>ul>li:nth-of-type(3)>a")).click();
	}
	
}
