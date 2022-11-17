package first_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebDriverSeleniumHQTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920,1080",
                "--disable-extensions", "--proxy-server='direct://'", "--proxy-bypass-list=*", "--start-maximized",
                "--disable-gpu", "--ignore-certificate-errors","user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }




    @Test
    public void addWatchesCasioWVSeriesToCart() throws InterruptedException {
        driver.get("https://www.casio.co.uk/");

        WebElement buttonCloseCookies = driver.findElement(By.id("hs-eu-decline-button"));
        buttonCloseCookies.click();

        WebElement buttonToAllWatchesList = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/header/div/nav/ul/li[1]/ul/li[2]")));

        buttonToAllWatchesList.click();
        WebElement buttonToClassicWatches;


        buttonToClassicWatches = (new WebDriverWait(driver, Duration.ofSeconds(10)))
              .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='maincontent']/div[2]/div/div/div[1]/div/div/div[2]/div[1]/a")));

        buttonToClassicWatches.click();

        WebElement buttonToWatches;
        buttonToWatches = driver.findElement(By.partialLinkText("WVA-M640D-2AER"));
        buttonToWatches.click();


        WebElement buttonAddToCart;
        buttonAddToCart = driver.findElement(By.className("tocart"));
        buttonAddToCart.click();

        WebElement buttonToCart;
        buttonToCart = driver.findElement(By.className("showcart"));
        buttonToCart.click();

        //Thread.sleep(3000);
        Assert.assertNotNull(driver.findElement(By.className("item-info")));
    }


    @Test
    public void searchForWatches() throws InterruptedException {
        driver.get("https://www.casio.co.uk/");

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("hs-eu-decline-button")));

        WebElement buttonCloseCookies = driver.findElement(By.id("hs-eu-decline-button"));
        buttonCloseCookies.click();

        WebElement searchBox;
        searchBox = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='search' and @placeholder='Search here']")));

        searchBox.sendKeys("F-91W-1XY");
        List<WebElement> searchResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li/a/div[@class='klevu-name-desc-l2']/div[@class='klevu-name-l2' and contains(.,'F-91W-1XY')]")));
        Assert.assertNotNull(searchResult);
        //Thread.sleep(3000);
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}


