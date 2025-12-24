package tests;

import java.time.Duration;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.Signupfuction;

public class SignupTest extends BaseTest{

	@Test(priority=1)
	
	public void uniquecredit() throws InterruptedException
	{
		logStep("Enter unique credentails for signup");
		Signupfuction unique=new Signupfuction(driver);
		
		logStep("click signup link");
		unique.clicksignuplink();
		Thread.sleep(4000);
		
		logStep("Enter unique user name");
		unique.signusernamefield("Vstest1");
		
		logStep("Enter unique password");
		unique.signpasswordfield("1234567test");
		
		logStep("Click on signup button ");
		unique.clicksignupbtn();
		Thread.sleep(4000);
		
		System.out.println("unique credentials = " + driver.switchTo().alert().getText());

		logPass(driver.switchTo().alert().getText() +"unique credentails");
		
		//logPass(driver.switchTo().alert().getText() +"unique credentails");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().alert().accept();
		
	}
	
	@Test(priority=2)
	public void existuser() throws InterruptedException
	{
		logStep("Enter exist user credentails for signup");
		Signupfuction exist=new Signupfuction(driver);
		
		logStep("click signup link");
		exist.clicksignuplink();
		Thread.sleep(4000);
		
		logStep("Enter exist user name");
		exist.signusernamefield("Vstest");
		
		logStep("Enter exist user password");
		exist.signpasswordfield("123456test");
		
		logStep("Click on signup button ");
		exist.clicksignupbtn();
		Thread.sleep(4000);
		
		System.out.println("existing user credentials = " + driver.switchTo().alert().getText());

		logPass(driver.switchTo().alert().getText() +"existing user credentails");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().alert().accept();
	}
	
	@Test(priority=3)
	public void emptyfield() throws InterruptedException
	{
		Signupfuction emptyfield=new Signupfuction(driver);
		emptyfield.clicksignuplink();
		Thread.sleep(4000);
		
		logStep("Enter empty user name");

		emptyfield.signusernamefield("");
		
		logStep("Enter empty password");

		emptyfield.signpasswordfield("");
		
		logStep("Click on signup button ");

		emptyfield.clicksignupbtn();
		Thread.sleep(4000);
		
		System.out.println("empty fields = " + driver.switchTo().alert().getText());
		logPass(driver.switchTo().alert().getText() +"empty field");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().alert().accept();
	}
	
	
}
