package page;

import model.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.ItemCreator;
import utils.Waits;

import java.time.Duration;

public class CasioItemPage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();

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
        logger.info("addItemToCart. Thread id is: " + Thread.currentThread().getId());
        return this;
    }
    public CasioItemPage goToCartPage(){
        Waits.getWebElementUntilWait(driver, goToCartButton);
        goToCart.click();
        logger.info("goto cart page");
        return this;
    }


    @Override
    public CasioItemPage openPage(){
        Item testItem = ItemCreator.withCredentialsFromProperty();
        driver.get(testItem.getItemURL());
        Waits.getWebElementUntilWait(driver, By.id("hs-eu-decline-button"));
        if(closeCookieWindowButton!=null) {
            closeCookieWindowButton.click();
            logger.info("close cookie window. Thread id is: "
                    + Thread.currentThread().getId()
                    + " page: " + testItem.getItemURL());
        }
        return this;
    }
}
