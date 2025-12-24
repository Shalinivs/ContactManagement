package tests;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.BrowserAndNavigationfuction;
import pages.LoginAndLogoutfunction;
import pages.Loginfunction;

public class BrowserAndNavigationTest extends BaseTest{

	@Test(priority=1)
	public void Relatedcategory() throws InterruptedException
	{
		/*
		   logStep("Strated test:for valid login");
		   Loginfunction login=new Loginfunction(driver);
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		   login.loginlinkclk();
		   login.logusernameetr("Testvs");
		   login.logpass("123456789");
		   login.logbtn();
		   */
		   
		logStep("User click the category from left menu revelant category should shown");
		BrowserAndNavigationfuction category=new BrowserAndNavigationfuction(driver);
		
		String[] categories= {"Phones","LapTops","Monitors"};
		logStep("select category");
		category.Allcategories(categories);
		logPass("Related category selected displayed");
		
	}
	
	
//	@Test(priority=2)
	public void Viewproductdetails() throws InterruptedException
	{
		logStep("user click on product image or title");
		BrowserAndNavigationfuction product=new BrowserAndNavigationfuction(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Thread.sleep(2000);
		String productname="Samsung galaxy s6";
		
		logStep("click product link");
		product.productlink(productname);
		Thread.sleep(2000);
		
		logPass("product details should displayed");
	}
	
	@Test(priority=3)
	public void Homenavigation()
	{
		logStep("user click on Home icon from home bar");
		BrowserAndNavigationfuction product=new BrowserAndNavigationfuction(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		logStep("click the home icon");
		product.Homemethod();
		
		logPass("Homepage is displayed showing all products");
		System.out.println("Homepage is displayed showing all products");
	}
	
	@Test(priority=4)
	public void navbarlink() throws InterruptedException
	{
		logStep("User clicks through Home, Cart, and Contact links");
		BrowserAndNavigationfuction product=new BrowserAndNavigationfuction(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		logStep("click on home icon");
		product.Homemethod();
		
		logStep("click on cart link");
		product.cartmethod();
		logPass("Respected cart page should open");
		
		logStep("click on cart link");
		product.contactmethod();
		logPass("Respected contact page should open");
		Thread.sleep(2000);
		logStep("click on close button on contact page");
		product.closecontactpage();
		logPass("contact page should close");
		
	}

	/*
	@Test(priority=5)
	public void logout()
	{
		logStep("Check logout funtionality");
		LoginAndLogoutfunction logout=new LoginAndLogoutfunction(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.navigate().refresh();
		logStep("click logoutlink");
		logout.logoutmethod();
		
		logPass("user should logout");
		
		System.out.println("Logout");	
	}
	*/
	
	
}
