package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CasioCartPage;
import page.CasioHomePage;
import page.CasioItemPage;

import java.time.Duration;

public class CasioTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private String watchesNameForSearch = "F-91W-1XY";
    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920,1080",
                "--disable-extensions", "--proxy-server='direct://'", "--proxy-bypass-list=*", "--start-maximized",
                "--disable-gpu", "--ignore-certificate-errors","user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    @Test
    public void addItemToCart(){
        new CasioItemPage(driver)
                .openPage()
                .addItemToCart()
                .goToCartPage();
        WebElement cartInfo = new CasioCartPage(driver)
                .getCartInfo();
        Assert.assertNotNull(cartInfo);
    }

    @Test
    public void searchResult(){
        int searchByNameResultSize = new CasioHomePage(driver)
                .openPage()
                .searchByNameResult(watchesNameForSearch);
        Assert.assertTrue(searchByNameResultSize > 0);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
