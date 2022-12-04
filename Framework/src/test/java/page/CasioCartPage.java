package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CasioCartPage extends AbstractPage{

    public static String CASIO_ITEM_PAGE_URL = "https://www.casio.co.uk/wva-m640d-2aer";

    @FindBy(id = "hs-eu-decline-button")
    private WebElement closeCookieWindowButton;


    @FindBy(xpath = "//*[@id='shopping-cart-table']/tbody/tr/td[1]/div/strong/a")
    private WebElement cartItemInfo;

    public CasioCartPage(WebDriver driver){
        super(driver);
    }

    public WebElement getCartInfo(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[1]/div/strong/a")));
        return cartItemInfo;
    }


    @Override
    public CasioCartPage openPage(){
        driver.get(CASIO_ITEM_PAGE_URL);
        return this;
    }
}

