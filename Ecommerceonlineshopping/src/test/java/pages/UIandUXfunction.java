package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UIandUXfunction {

    WebDriver driver;

    By productCards = By.xpath("//div[@id='tbodyid']/div");
    By addToCart = By.id("cartur");
    By login = By.id("login2");
    By signin = By.id("signin2");

    public UIandUXfunction(WebDriver driver)
    {
        this.driver = driver;
    }

    // Returns all product cards
    public List<WebElement> getProductCards()
    {
        return driver.findElements(productCards);
    }

    // Card width consistency
    public boolean verifyCardWidthConsistency() 
    {
        List<WebElement> cards = getProductCards();
        int expectedWidth = cards.get(0).getSize().getWidth();

        for (WebElement card : cards) {
            if (card.getSize().getWidth() != expectedWidth)
                return false;
        }
        return true;
    }

    // Card height consistency
    public boolean verifyCardHeightConsistency() {
        List<WebElement> cards = getProductCards();
        int expectedHeight = cards.get(0).getSize().getHeight();

        for (WebElement card : cards) {
            if (card.getSize().getHeight() != expectedHeight)
                return false;
        }
        return true;
    }

    // Horizontal alignment check
    public boolean verifyCardAlignment() {
        List<WebElement> cards = getProductCards();
        int expectedY = cards.get(0).getLocation().getY();

        for (WebElement card : cards) {
            if (card.getLocation().getY() != expectedY)
                return false;
        }
        return true;
    }

    // Spacing check
    public boolean verifyCardSpacing() {
        List<WebElement> cards = getProductCards();

        if (cards.size() < 2) return false;

        int firstX = cards.get(0).getLocation().getX();
        int secondX = cards.get(1).getLocation().getX();
        int expectedSpacing = secondX - firstX;

        for (int i = 0; i < cards.size() - 1; i++) 
        {
            int spacing = cards.get(i + 1).getLocation().getX() - cards.get(i).getLocation().getX();
            if (spacing != expectedSpacing)
                return false;
        }
        return true;
    }   

    // Button visibility check
      public boolean isAddtocartbuttonvisible() 
      {
        WebElement btn = driver.findElement(addToCart);
        return btn.isDisplayed() && btn.isEnabled();
    }
      
      public boolean isloginbuttonvisible() 
      {
        WebElement btn = driver.findElement(addToCart);
        return btn.isDisplayed() && btn.isEnabled();
    }
      
      public boolean issigninvisible() 
      {
        WebElement btn = driver.findElement(addToCart);
        return btn.isDisplayed() && btn.isEnabled();
    }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
}
