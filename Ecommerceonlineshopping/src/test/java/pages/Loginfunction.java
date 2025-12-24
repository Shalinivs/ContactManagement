package pages;

import org.apache.commons.math3.analysis.function.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginfunction {

	WebDriver driver;
	
	//locate elements
   By loglink= By.id("login2");
   By logusername=By.id("loginusername");
   By logpass=By.id("loginpassword");
   By logbtn=By.xpath("//button[text()='Log in']");
   By logclose=By.xpath("//button[@fdprocessedid='ncn179']");
   
   public Loginfunction(WebDriver driver)
   {
	   this.driver=driver;
   }
   
   


   public void loginlinkclk()
   {
	   driver.findElement(loglink).click();
	  
   }
   
   public void logusernameetr(String username)
   {
	   driver.findElement(logusername).sendKeys(username);
   }
   
   public void logpass(String password)
   {
	   driver.findElement(logpass).sendKeys(password);
   }
   
   public void logbtn()
   {
	   driver.findElement(logbtn).click();
   }
   
   public void logclose()
   {
	   driver.findElement(logclose).click();
   }
   
		   
	
	
}
