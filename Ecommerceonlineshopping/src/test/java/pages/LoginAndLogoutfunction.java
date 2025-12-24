package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAndLogoutfunction {
	WebDriver driver;
	
	public LoginAndLogoutfunction(WebDriver driver)
	{
		this.driver=driver;
	}

	
	By Logoutbtn=By.id("logout2");
	
	public void logoutmethod()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Logoutbtn));
		driver.findElement(Logoutbtn).click();
	}
}
