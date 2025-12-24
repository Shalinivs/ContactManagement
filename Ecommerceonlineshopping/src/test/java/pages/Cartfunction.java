package pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cartfunction {
	
	WebDriver driver;
	
	public Cartfunction(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By cartlink=By.xpath("//a[normalize-space()='Cart']");
	By products=By.xpath("//a[@class='hrefch']");
	By nextbtn=By.id("next2");
	By prevbtn=By.id("prev2");
	By Addcartbtn=By.xpath("//a[text()='Add to cart']");
	By productTitle=By.xpath("//tbody[@id='tbodyid']/tr/td[2]");
	By productprice=By.xpath("//tbody[@id='tbodyid']/tr/td[3]");
	By deleteproduct=By.xpath("//a[text()='Delete']");
	By Logoutbtn=By.id("logout2");

	
	
	public void clkcartlink()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartlink));
		driver.findElement(cartlink).click();
	}
	
	public void selectproduct()
	// driver.findElement(products).click();

	{
	
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(products));
		 
		List<WebElement> productList= driver.findElements(products);
		
		 if (!productList.isEmpty()) 
		 {
		        productList.get(0).click();
		        
		        wait.until(ExpectedConditions.visibilityOfElementLocated(Addcartbtn));
		
		 }
	}
			
	
	
	public void clknextbtn()
	{
		driver.findElement(nextbtn).click();
	}
	
	public void clickprevbtn()
	{
		driver.findElement(prevbtn).click();
	}

	public void clkaddcartbtn()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement clkcart = wait.until(ExpectedConditions.visibilityOfElementLocated(Addcartbtn));
		clkcart.click();
		
	/*	wait.until(ExpectedConditions.alertIsPresent());
	    driver.switchTo().alert().accept();*/

	}
	
	public String titleofproduct()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement itemTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
	     return itemTitle.getText();

	}
	
	public String priceofproduct()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement itemprice = wait.until(ExpectedConditions.visibilityOfElementLocated(productprice));
		return itemprice.getText();
	}
	
	public void Delete()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(deleteproduct)).click();
		

		
	}

	public void selectMulproduct(String prodname) {

		
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
			 List<WebElement> productList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(products));
			
			for(WebElement product : productList)
			{
				if(product.getText().equalsIgnoreCase(prodname))
					product.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(Addcartbtn));
				break;
			}
	}
	
	public void logoutmethod()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Logoutbtn));
		driver.findElement(Logoutbtn).click();
	}
		
	
	

}
