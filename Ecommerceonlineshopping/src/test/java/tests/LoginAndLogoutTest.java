package tests;

import java.time.Duration;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginAndLogoutfunction;
import pages.Loginfunction;

public class LoginAndLogoutTest extends BaseTest {
	
	
	@Test(priority=1)
	
	public void login()
	{
	   logStep("login with valid details");
	   Loginfunction login=new Loginfunction(driver);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	   
	   logStep("click on login link");
	   login.loginlinkclk();
	   
	   logStep("Enter user name");
	   login.logusernameetr("Testvs");
	   
	   logStep("Enter password");
	   login.logpass("123456789");
	   
	   logStep("click on login button");
	   login.logbtn();
	   
	   logPass("login success");
	}
	
	@Test(priority=2,dependsOnMethods = "login")

	public void logout()
	{
		logStep("check logout function");
		LoginAndLogoutfunction logout=new LoginAndLogoutfunction(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.navigate().refresh();
		
		logStep("click on logout link");
		logout.logoutmethod();
		
		logPass("logout success");
		System.out.println("Logout");

		
	}

}
