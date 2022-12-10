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

    @FindBy(xpath = "//li/a/div[@class='klevu-name-desc-l2']/div[@class='klevu-name-l2']")
    private List<WebElement> searchingItems;

    private final By searchInputBox = By.xpath("//input[@id='search' and @placeholder='Search here']");

    private final By searchResults = By.xpath("//li/a/div[@class='klevu-name-desc-l2']/div[@class='klevu-name-l2']");

    private final By emptySearchMessage = By.xpath("//div[@class='klevuNoResults-message']");

    public CasioHomePage(WebDriver driver){
        super(driver);
    }

    public List<String> searchByNameResult(String testItem){
        setTextInSearchBox(testItem);
        //Waits.getWebElementUntilWait(driver, searchResults);
        //List<WebElement> searchResult = driver.findElements(searchResults);
        return searchingItems.stream().map(it -> it.getText().toLowerCase()).collect(Collectors.toList());
    }

    public String getEmptySearchMessage(){
        Waits.getWebElementUntilWait(driver, emptySearchMessage);
        System.out.println(driver.findElements(emptySearchMessage).size());
        return driver.findElement(emptySearchMessage).getText();
    }

    public void setTextInSearchBox(String text){
        Waits.getWebElementUntilWait(driver, searchInputBox);
        searchBox.sendKeys(text);
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
