package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waits;

import java.util.ArrayList;
import java.util.List;

public class CasioCollectionPage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();
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
        logger.info("get price of items: " + prices.toString());
        return prices;
    }

    @Override
    public CasioCollectionPage openPage(){
        driver.get("https://www.casio.co.uk/watches-clocks/casio-collection");
        Waits.getWebElementUntilWait(driver, By.id("hs-eu-decline-button"));
        if(closeCookieWindowButton!=null) {
            logger.info("Close cookie Window");
            closeCookieWindowButton.click();
        }
        return this;
    }
}
