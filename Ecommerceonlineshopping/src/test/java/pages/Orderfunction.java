package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Orderfunction {

	WebDriver driver;
	
	public Orderfunction(WebDriver driver)
	{
		this.driver=driver;
	}
	
//	By placeorder=By.xpath("(//button[normalize-space()='Place Order'])[1]");
    By placeorder=By.xpath("//button[normalize-space()='Place Order']");
    By name=By.id("name");
    By country= By.id("country");
    By city=By.id("city");
    By card=By.id("card");
    By month=  By.id("month");
    By year= By.id("year");
    By purchase= By.xpath("//button[text()='Purchase']");
    By close= By.xpath("//div[@id='exampleModal']//button[@type='button'][normalize-space()='Close']");
	By cartlink=By.xpath("//a[normalize-space()='Cart']");
	By ordermodel=By.id("orderModal");

    
    public void clkplaceorderbtn()
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
    	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("orderModal")));
    	driver.findElement(placeorder).click();
    	/*
    	WebElement placeorderbtn=wait.until(ExpectedConditions.visibilityOfElementLocated(placeorder));
    	placeorderbtn.click();
    	*/
    }
    
    public void clkordermodel()
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
    	WebElement checkordermodel=wait.until(ExpectedConditions.visibilityOfElementLocated(placeorder));
    	checkordermodel.click();
    }
    
    public void namemethod(String username)
    {
    	driver.findElement(name).sendKeys(username);
    }
    public void countrymethod(String usercountry)
    {
    	driver.findElement(country).sendKeys(usercountry);
    }
    public void citymethod(String usercity)
    {
    	driver.findElement(city).sendKeys(usercity);
    }
    public void cardmethod(String usernamont)
    {
    	driver.findElement(card).sendKeys(usernamont);
    }
    public void monthmethod(String usermonth)
    {
    	driver.findElement(month).sendKeys(usermonth);
    }
    
    public void yearmethod(String useryear)
    {
    	driver.findElement(year).sendKeys(useryear);
    }
    public void purchasebtnmethod()
    {
    	driver.findElement(purchase).click();
    }
    public void closebtnmethod()
    {
    	driver.findElement(name).click();
    }
    
    public void clkcartlink()
	{
		driver.findElement(cartlink).click();
	}
    
   
        
}
