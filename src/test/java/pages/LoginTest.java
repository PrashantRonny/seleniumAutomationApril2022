package pages;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

//	@Test(priority=1)
	public void login_userName_Password_blank_tc_01() {
		lp.clickLoginButton();
		lp.verifyErrorMessage("Username cannot be empty");
	}
	@Test(priority=2)
	public void login_userName_Password_blank_tc_02() {
		lp.enterUserName("Admin");
		lp.clickLoginButton();
		lp.verifyErrorMessage("Password cannot be empty");
	}
	@Test(priority=3)
	public void login_userName_Password_blank_tc_03() {
		lp.enterUserName(conf.getUserName());
	//	lp.enterPassword(conf.getPassword());
		lp.enterPassword(conf.getInvalidPassword());
		lp.clickLoginButton();
		lp.verifyErrorMessage("Invalid credentials");
	}
	@Test(priority=4)
	public void login_userName_validCredential() {
		lp.enterUserName(conf.getUserName());
		lp.enterPassword(conf.getPassword());
	//	lp.enterPassword(conf.getInvalidPassword());
		lp.clickLoginButton();
		lp.verifyErrorMessage("Invalid credentials");
	}
	
}
