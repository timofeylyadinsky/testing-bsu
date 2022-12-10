package page;

import model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waits;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CasioHomePage extends AbstractPage{
    public static String CASIO_HOME_PAGE_URL = "https://www.casio.co.uk/";

    @FindBy(id = "hs-eu-decline-button")
    private WebElement closeCookieWindowButton;

    @FindBy(xpath = "//input[@id='search' and @placeholder='Search here']")
    private WebElement searchBox;
    private final By searchInputBox = By.xpath("//input[@id='search' and @placeholder='Search here']");

    private final By searchResults = By.xpath("//li/a/div[@class='klevu-name-desc-l2']/div[@class='klevu-name-l2']");

    public CasioHomePage(WebDriver driver){
        super(driver);
    }

    public List<String> searchByNameResult(String testItem){
        Waits.getWebElementUntilWait(driver, searchInputBox);
        searchBox.sendKeys(testItem);
        Waits.getWebElementUntilWait(driver, searchResults);
        List<WebElement> searchResult = driver.findElements(searchResults);
        return searchResult.stream().map(it -> it.getText().toLowerCase()).collect(Collectors.toList());
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
