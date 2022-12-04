package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waits;

import java.time.Duration;

public class CasioItemPage extends AbstractPage{

    public static String CASIO_ITEM_PAGE_URL = "https://www.casio.co.uk/wva-m640d-2aer";

    @FindBy(id = "hs-eu-decline-button")
    private WebElement closeCookieWindowButton;

    @FindBy(xpath = "//*[@id='product-addtocart-button']")
    private WebElement addToCart;

    @FindBy(xpath = "//*[@class='action showcart']")
    private WebElement goToCart;


    private By addToCartButton = By.xpath("//*[@id='product-addtocart-button']");
    private By goToCartButton = By.xpath("//*[@class='action showcart']");


    public CasioItemPage(WebDriver driver){
        super(driver);
    }

    public CasioItemPage addItemToCart(){
        Waits.getWebElementUntilWait(driver, addToCartButton);
        addToCart.click();
        return this;
    }
    public CasioItemPage goToCartPage(){
        Waits.getWebElementUntilWait(driver, goToCartButton);
        goToCart.click();
        return this;
    }


    @Override
    public CasioItemPage openPage(){
        driver.get(CASIO_ITEM_PAGE_URL);
        Waits.getWebElementUntilWait(driver, By.id("hs-eu-decline-button"));
        if(closeCookieWindowButton!=null) {
            closeCookieWindowButton.click();
        }
        return this;
    }
}
