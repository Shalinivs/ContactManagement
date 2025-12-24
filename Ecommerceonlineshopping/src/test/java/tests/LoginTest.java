package tests;


import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import jdk.internal.org.jline.utils.Log;
import pages.Loginfunction;

public class LoginTest extends BaseTest{
	
	
	//private static final Logger logger=LogManager.getLogger(LoginTest.class);
	
	@Test(priority=1)
	public void loginWvalidcredential()
	{
		logStep("Strated test:for valid login");
	   Loginfunction login=new Loginfunction(driver);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	   
	   logStep("click login link");
	   login.loginlinkclk();
	   
	   logStep("Enter valid username");
	   login.logusernameetr("Testvs");
	   
	   logStep("Enter valid password");
	   login.logpass("123456789");
	   
	   logStep("click on login button");
	   login.logbtn();
	   
	   logPass("Login success");
	   handleAlertIfPresent("valid");
	   
	 //  System.out.println("User is redirect to cantact list page");
	 //  Log.info("User is redirect to cantact list page");
	}
	
	@Test(priority=2)
	public void incrtpassword()
	{
		logStep("Strated test:for login with incorrect password");
		 Loginfunction login=new Loginfunction(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		 
		 logStep("click login link");
		 login.loginlinkclk();
		 
		 logStep("Enter valid username");
		 login.logusernameetr("Testvs");
		 
		 logStep("Enter valid password");
		 login.logpass("123");
		 
		 logStep("click on login button");
		 login.logbtn();
		 
		 logPass("Login not success alret message is shown");
		 handleAlertIfPresent("incorrect password");
		// System.out.println("incorrect email or password shown");
		// Log.error("incorrect email or password shown");
		  
	}
	
	@Test(priority=3)
	public void emtyfield()
	{
		logStep("Strated test:for login with Empty fields");
		 Loginfunction login=new Loginfunction(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		 
		 logStep("click login link");
		 login.loginlinkclk();
		 
		 logStep("Enter empty username");
         login.logusernameetr(" ");
         
		 logStep("Enter empty password");
		 login.logpass(" ");
		 
		 logStep("click on login button");
		 login.logbtn();
		 
		 logPass("Login not success alret message is shown for emptyfield");
		 handleAlertIfPresent("empty field");
		// System.out.println("validation message for empty field");
		 //Log.warn("validation message for empty field");
	}
	
	@Test(priority=4)
	public void invalidemailformat()
	{
		logStep("Strated test:for login with invalid email format");
		 Loginfunction login=new Loginfunction(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		 
		 logStep("click login link");
		 login.loginlinkclk();
		 
		 logStep("Enter invalid emailformat");
		 login.logusernameetr("Test vs");
		 
		 logStep("Enter invalid password");
		 login.logpass(" ");
		 
		 logStep("click on login button");
		 login.logbtn();
		 
		 logPass("Login not success alret message is shown for invalid email format");
		 handleAlertIfPresent("invalid email format");
		 
		// System.out.println("invalid email format");
		// Log.warn("invalid email format");
	}
	
	@Test(priority=5)
	public void maskinput()
	{
		logStep("Strated test:for login with entering mask input");
		 Loginfunction login=new Loginfunction(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 
		 logStep("click login link");
		 login.loginlinkclk();
		 
		 logStep("Enter mask username");
		 login.logusernameetr("*****");
		 
		 logStep("Enter mask passowrd");
		 login.logpass("****");
		 
		 logStep("click on login button");
		 login.logbtn();
		 
		 logPass("Login not success alret message is shown for mask input");
		 handleAlertIfPresent("mask input");
		// System.out.println("mask input");
		// Log.error("mask input");
	}
	
	// handle alrets
	
	 public void handleAlertIfPresent(String scenario) {
	        try {
	            Thread.sleep(3000);

	            Alert alert = driver.switchTo().alert();
	            String alertText = alert.getText();

	            logPass("Alert appeared for scenario: " + scenario);
	            logStep("Alert Text: " + alertText);
	          //  logger.info("Alert: " + alertText);

	            alert.accept();
	            logPass("Alert accepted successfully");

	        } catch (Exception e) {
	            logFail("❌ No Alert appeared for: " + scenario);
	           // logger.error("No alert for: " + scenario);
	        }
	    }
	}

	
	


