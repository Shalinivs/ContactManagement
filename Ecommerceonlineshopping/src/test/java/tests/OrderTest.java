package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.Cartfunction;
import pages.Loginfunction;
import pages.Orderfunction;

public class OrderTest extends BaseTest{
	
	@Test(priority=1)
	public void loginWvalidcredential()
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
	
	@Test(priority=2,dependsOnMethods = "loginWvalidcredential")
	public void Addproducttocart() throws InterruptedException
	{
		logStep("Select a product and Added to cart");
		Cartfunction selectitem=new Cartfunction(driver);
		//selectitem.clkcartlink();
		
		String producttoselect="Samsung galaxy s6";
		Thread.sleep(4000);
		
		logStep("Select product");
		selectitem.selectMulproduct(producttoselect);
		logPass("Selected product : product name -" +producttoselect);
		System.out.println("selected product name= " +producttoselect);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		logStep("click on Add to cart button");
		selectitem.clkaddcartbtn();
		Thread.sleep(3000);

		logPass("Added product to cart and Alert got accept - " +producttoselect);
		System.out.println("Added product to cart =" +producttoselect);
	    //Thread.sleep(4000);
		driver.switchTo().alert().accept();
	}
	
	
	@Test(priority=3,dependsOnMethods = "Addproducttocart")
	public void purchasewithvaliddetails() throws InterruptedException
	{
		logStep("test start: place order by entering valid details");
		Orderfunction order=new Orderfunction(driver);
	
		logStep("click cart link");
		order.clkcartlink();
		
		Thread.sleep(2000);
		logStep("click place order button");
		order.clkplaceorderbtn();
		
		Thread.sleep(2000);

		logStep("Enter username");
		order.namemethod("testvs");
		logStep("Enter country");
		order.countrymethod("india");
		logStep("Enter city");
		order.citymethod("Bangalore");
		
		logStep("Enter cardno");
		order.cardmethod("123456789");
		
		logStep("Enter month");
		order.monthmethod("november");
		logStep("Enter year");
		order.yearmethod("2025");
		logStep("click purchase button");
		order.purchasebtnmethod();
	
		
	//	logPass("confirmation message=" +driver.switchTo().alert().getText());
	    System.out.println("confirmation message="+driver.switchTo().alert().getText());
	    
	    
	   // System.out.println("confirmation message ");
				
	}
	
	@Test(priority=4, dependsOnMethods = "purchasewithvaliddetails")
	public void emptyfields() throws InterruptedException
	{
		logStep("test start: place order by empty details");
		Orderfunction order=new Orderfunction(driver);
		
		logStep("click cart link");
		order.clkcartlink();
		
		order.clkordermodel();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		logStep("click place order button");
		order.clkplaceorderbtn();
		
		Thread.sleep(2000);

		logStep("click place order button");
		order.clkplaceorderbtn();
		
		logStep("Should not enter username");
		order.namemethod("");
		logStep("Should not enter username");
		order.countrymethod("");
		
		logStep("Should not enter city");
		order.citymethod("");
		
		logStep("should not enter cardno");
		order.cardmethod("");
		
		logStep("Should not enter month");
		order.monthmethod("");
		
		logStep("Should not enter year");
		order.yearmethod("");
		
		logStep("click on puechase button");
		order.purchasebtnmethod();
	
		
		//logPass("confirmation message=" +driver.switchTo().alert().getText());
	    System.out.println("confirmation message="+driver.switchTo().alert().getText());
	    
	    
	 //   System.out.println("confirmation message=");
				
	}
	
	@Test(priority=5, dependsOnMethods = "Addproducttocart")
	public void confirm() throws InterruptedException
	{
		logStep("test start: after purchase check confirmation dialoag");
		Orderfunction order=new Orderfunction(driver);
		
		logStep("click cart link");
		order.clkcartlink();
	
		order.clkordermodel();
		 

		
		logStep("click place order button");
		order.clkplaceorderbtn();
		Thread.sleep(2000);

		logStep("Enter username");
		order.namemethod("testvs");
		
		logStep("Enter country");
		order.countrymethod("india");
		
		logStep("Enter city");
		order.citymethod("Bangalore");
		
		logStep("Enter cardno");
		order.cardmethod("123456789");
		
		logStep("Enter month");
		order.monthmethod("november");
		
		logStep("Enter year");
		order.yearmethod("2025");
		
		logStep("click on purchase button");
		order.purchasebtnmethod();
		/*
		logPass("confirmation message="+driver.switchTo().alert().getText());
	    System.out.println("confirmation message="+driver.switchTo().alert().getText());
	    */
	    
	    System.out.println("confirmation message=");
				
	}
	
	
	
	

}
