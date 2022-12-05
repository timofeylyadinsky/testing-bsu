package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class CasioCartPage extends AbstractPage{

    public static String CASIO_ITEM_PAGE_URL = "https://www.casio.co.uk/checkout/cart/";

    @FindBy(id = "hs-eu-decline-button")
    private WebElement closeCookieWindowButton;




    private By cartItem = By.xpath("//div[@class='product-item-details']/strong");

    public CasioCartPage(WebDriver driver){
        super(driver);
    }

    public String getCartInfo(){
         List<WebElement> cartItemInfo = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(cartItem));
         String listOfNameAllItemsInCart = "";
         for(WebElement i : cartItemInfo){
             listOfNameAllItemsInCart += i.getText() + "\n";
         }
         System.out.println("Text:\n" + listOfNameAllItemsInCart);
        return listOfNameAllItemsInCart;
    }


    @Override
    public CasioCartPage openPage(){
        driver.get(CASIO_ITEM_PAGE_URL);
        return this;
    }
}

