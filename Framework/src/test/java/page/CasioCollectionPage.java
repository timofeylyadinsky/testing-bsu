package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waits;

import java.util.ArrayList;
import java.util.List;

public class CasioCollectionPage extends AbstractPage{

    @FindBy(id = "hs-eu-decline-button")
    private WebElement closeCookieWindowButton;

    @FindBy(xpath = "//span/span[@class='price']")
    private List<WebElement> priceText;

    public CasioCollectionPage(WebDriver driver){super(driver);}

    public List<Double> getPriceList(){
        List<Double> prices = new ArrayList<>();
        for(WebElement itemPrice: priceText){
            prices.add(Double.parseDouble(itemPrice.getText().substring(1)));
        }
        return prices;
    }

    @Override
    public CasioCollectionPage openPage(){
        driver.get("https://www.casio.co.uk/watches-clocks/casio-collection");
        Waits.getWebElementUntilWait(driver, By.id("hs-eu-decline-button"));
        if(closeCookieWindowButton!=null) {
            closeCookieWindowButton.click();
        }
        return this;
    }
}
