package tests;

import java.time.Duration;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.Loginfunction;
import pages.UIandUXfunction;

public class UIandUXTest extends BaseTest{
	
	 UIandUXfunction ui;

	    @BeforeMethod
	    public void setupPages() 
	    {
	        ui = new UIandUXfunction(driver);
	    }


	@Test(priority=1)
	public void loginWvalidcredential()
	{
	   Loginfunction login=new Loginfunction(driver);
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
	   login.loginlinkclk();
	   login.logusernameetr("Testvs");
	   login.logpass("123456789");
	   login.logbtn();
	   
	}

	@Test(priority=2)
	public void verifyProductCardAlignmentAndSpacing()
	{
		UIandUXfunction cardtest=new UIandUXfunction(driver);
		Assert.assertTrue(cardtest.verifyCardWidthConsistency(),
                "Product cards do not have the same width!");

        Assert.assertTrue(cardtest.verifyCardHeightConsistency(),
                "Product cards do not have the same height!");

        Assert.assertTrue(cardtest.verifyCardAlignment(),
                "Product cards are not aligned properly!");

        System.out.println("UI/UX check passed → Product cards are aligned and consistent.");
    }
/*	
	
	@Test(priority=3)
	public void verifyProductCardSpacingTest() {
		UIandUXfunction cardtest=new UIandUXfunction(driver);

	    boolean result = cardtest.verifyCardSpacing();

	    Assert.assertTrue(result, "Product card spacing is NOT consistent!");
	}
	*/
	
	 @Test(priority=3)
	    public void verifyButtonsVisibility()
	 {
	        Assert.assertTrue(ui.isAddtocartbuttonvisible(), "Add to Cart button is NOT visible!");
	        Assert.assertTrue(ui.isloginbuttonvisible(), "Login button is NOT visible!");
	        Assert.assertTrue(ui.issigninvisible(), "Sign Up button is NOT visible!");
	        Assert.assertTrue(ui.issigninvisible(), "Cart link is NOT visible!");

	        System.out.println("All header buttons are visible and clickable.");
	    }

	    @Test(priority=4) void verifyCardUIUX() 
	    {
	        Assert.assertTrue(ui.verifyCardWidthConsistency(), "Card width mismatch");
	        Assert.assertTrue(ui.verifyCardHeightConsistency(), "Card height mismatch");
	        Assert.assertTrue(ui.verifyCardAlignment(), "Cards not aligned");
	        Assert.assertTrue(ui.verifyCardSpacing(), "Card spacing not consistent");

	        System.out.println("Card UI/UX looks consistent!");
	    }
	
	
}
