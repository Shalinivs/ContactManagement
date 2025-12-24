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

public class CartTest extends BaseTest {
	
	//login
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
	
	//select single item and add to cart
	@Test(priority=2, dependsOnMethods = "loginWvalidcredential")
	public void producttocart() throws InterruptedException
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
	
	//get the product title and price
	@Test(priority=3, dependsOnMethods = "producttocart")
	public void productdetails() throws InterruptedException
	{
		logStep("Get the product price and title");
		Cartfunction selectitem=new Cartfunction(driver);
		
		logStep("click cart link");
		selectitem.clkcartlink();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    
		
		logStep("get the product title");
		String producttitle=selectitem.titleofproduct();
		
		logStep("get the product price");
		String productprice=selectitem.priceofproduct();
		Thread.sleep(3000);
		logPass("product title =" +producttitle);
		logPass("product price =" +productprice);
	    System.out.println("product title ="+producttitle);
	    System.out.println("product price ="+productprice);

	}
	
	/*
	@Test(priority=4)
	  public void addAndVerifyProductInCart() throws InterruptedException {
	        loginWvalidcredential();
	        producttocart();
	        productdetails();
	    }
	    */
	
	/*
	@Test(priority=3)
	public void logout()
	{
		Cartfunction selectitem=new Cartfunction(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		selectitem.logoutmethod();
	}
	*/

	/*
	@Test(priority=4)
	public void deletetheproduct()
	{
		Cartfunction selectitem=new Cartfunction(driver);
		selectitem.Delete();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		System.out.println("deleted success");
		
	}
	
	@Test(priority=5)
	public void addmultipleitem() throws InterruptedException
	{
		Cartfunction selectitem=new Cartfunction(driver);
		
		String producttoselect1="Samsung galaxy s6";
		selectitem.selectMulproduct(producttoselect1);
		System.out.println(producttoselect1);
		selectitem.clkaddcartbtn();
		
		driver.navigate().back();
		Thread.sleep(2000);
	    
		String producttoselect2="Samsung galaxy s6";
		selectitem.selectMulproduct("Nokia lumia 1520");
		selectitem.selectMulproduct(producttoselect2);
		System.out.println(producttoselect2);
		selectitem.clkaddcartbtn();
		
		
	}
	
	*/
	}

	

