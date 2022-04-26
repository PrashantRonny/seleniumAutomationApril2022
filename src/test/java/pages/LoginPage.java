package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

		WebDriver driver;
		public LoginPage(WebDriver rdriver) {
			this.driver = rdriver;
		}
		By txt_UserName = By.cssSelector("input#txtUsername");
		By txt_Password = By.cssSelector("input#txtPassword");
		By btn_Login = By.cssSelector("input#btnLogin");
		By lbl_errorMessage = By.id("spanMessage");
		
		//methods
		public void enterUserName(String user) {
			driver.findElement(txt_UserName).clear();
			driver.findElement(txt_UserName).sendKeys(user);
		}
		public void enterPassword(String pass) {
			driver.findElement(txt_Password).clear();
			driver.findElement(txt_Password).sendKeys(pass);
		}
		public void clickLoginButton() {
			driver.findElement(btn_Login).click();
		}
		public void verifyErrorMessage(String expectedErrorMsg) {
			String actualErrorMsg = driver.findElement(lbl_errorMessage).getText();
			Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		}
}
