package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CasioHomePage extends AbstractPage{
    public static String CASIO_HOME_PAGE_URL = "https://www.casio.co.uk/";

    @FindBy(id = "hs-eu-decline-button")
    private WebElement closeCookieWindowButton;

    public CasioHomePage(WebDriver driver){
        super(driver);
    }

    @Override
    public CasioHomePage openPage(){
        driver.get(CASIO_HOME_PAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("hs-eu-decline-button")));
        closeCookieWindowButton.click();
        return this;
    }
}
