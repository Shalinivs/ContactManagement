package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Signupfuction {
		
  WebDriver driver;
  
  //locate elment 
     By signuplink = By.id("signin2");
     By usernamefield = By.id("sign-username");
     By passwordfield =  By.id("sign-password");
     By signupbtn =  By.xpath("//button[text()='Sign up']");
     By closebtn =  By.xpath("//button[@fdprocessedid='mstypj']");
     
     //contractor
     public Signupfuction(WebDriver driver)
     {
    	 this.driver = driver;
     }
     
     public void clicksignuplink()
     {
    	 driver.findElement(signuplink).click();
     }
     
     public void signusernamefield(String username)
     {
    	 driver.findElement(usernamefield).sendKeys(username);
     }
     
     public void signpasswordfield(String password)
     {
    	 driver.findElement(passwordfield).sendKeys(password);
     }
     
     public void clicksignupbtn()
     {
    	 driver.findElement(signupbtn).click();
     }
     
     public void clickclosebtn()
     {
    	 driver.findElement(closebtn).click();
     }
}
