package base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {
	
	protected WebDriver driver;
	
	public static ExtentReports extent;
	 public static  ExtentTest test;
	 
	 
	 @BeforeSuite
	    public void initiateExtentReport() {
	        ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(spark);
	    }
	
	@BeforeMethod
	public void browserlaunch(Method method)
	{
		test = extent.createTest(method.getName());
		
		driver=new ChromeDriver();
		//driver=new FirefoxDriver();
		//driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/");
	}
	
	@AfterMethod
	public void closebrowser()
	{
		driver.quit();
	}
	
	 @AfterSuite
	    public void closeReport() {
	        extent.flush();
	    }
	
	public void logStep(String msg) {
        test.info(msg);
    }

    public void logPass(String msg) {
        test.pass(msg);
    }

    public void logFail(String msg) {
        test.fail(msg);
    }
	
	

}
