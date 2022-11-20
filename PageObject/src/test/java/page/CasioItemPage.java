package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CasioItemPage extends AbstractPage{

    public static String CASIO_ITEM_PAGE_URL = "https://www.casio.co.uk/wva-m640d-2aer";

    @FindBy(id = "hs-eu-decline-button")
    private WebElement closeCookieWindowButton;

    @FindBy(xpath = "//*[@id='product-addtocart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@class='action showcart']")
    private WebElement goToCartButton;


    public CasioItemPage(WebDriver driver){
        super(driver);
    }

    public CasioItemPage addItemToCart(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='product-addtocart-button']")));
        addToCartButton.click();
        return this;
    }
    public CasioItemPage goToCartPage(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='action showcart']")));
        goToCartButton.click();
        return this;
    }


    @Override
    public CasioItemPage openPage(){
        driver.get(CASIO_ITEM_PAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("hs-eu-decline-button")));
        closeCookieWindowButton.click();
        return this;
    }
}
