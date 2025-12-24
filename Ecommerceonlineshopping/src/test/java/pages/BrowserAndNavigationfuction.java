package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserAndNavigationfuction {
	
	WebDriver driver;
	
	public BrowserAndNavigationfuction(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By categories=By.xpath("//a[@id='itemc']");
	By imglink=By.xpath("//img[@class='card-img-top img-fluid']");
	By textlink=By.xpath("//h4[@class='card-title']/a");
	By Homeicon=By.xpath("//li[@class='nav-item active']/a");
	By contact=By.xpath("//li[@class='nav-item']/a[normalize-space()='Contact']");
	By cartlink=By.xpath("//a[normalize-space()='Cart']");
	By contactclose=By.xpath("//div[@id='exampleModal']//button[@type='button'][normalize-space()='Close']");
	By Logoutbtn=By.id("logout2");
	
	
	public void Allcategories(String[] categorynames) throws InterruptedException
	{
		List<WebElement> alltypes=driver.findElements(categories);
		
		for(String categoryname : categorynames)
		{
		for(WebElement category : alltypes)	
		{
			String text =category.getText().trim();
			
			if(text.equalsIgnoreCase(categoryname))
			System.out.println("clicked category name = "+ categoryname);
			category.click();
			
			Thread.sleep(3000);
			
			driver.navigate().back();
			Thread.sleep(3000);
			
			alltypes=driver.findElements(categories);
		}
	
		}
	}
	
	public void productlink(String productname)
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		 
		List<WebElement> products = driver.findElements(textlink);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(textlink));

		
		boolean productfound=false;
		
		for(WebElement product : products)
		{
			String name=product.getText().trim();
			if(name.equalsIgnoreCase(productname.trim()))
				System.out.println(name);
				
				wait.until(ExpectedConditions.elementToBeClickable(product)).click();
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(textlink));

				System.out.println("product details page open for  ="+ name);
				productfound=true;
				break;
		}
	
	if(!productfound)
	{
		System.out.println("product not found ="+ productfound);
	}
	
}
	
	public void Homemethod()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.findElement(Homeicon).click();
	}
	public void cartmethod()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.findElement(cartlink).click();
		
	}
	
	public void contactmethod()
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(contact));
		driver.findElement(contact).click();
		
	}
	
	public void closecontactpage()
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(contactclose));
		driver.findElement(contactclose).click();
	}
	
	
}
	


