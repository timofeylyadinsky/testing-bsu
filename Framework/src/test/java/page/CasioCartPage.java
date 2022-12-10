package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waits;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class CasioCartPage extends AbstractPage{

    public static String CASIO_ITEM_PAGE_URL = "https://www.casio.co.uk/checkout/cart/";

    @FindBy(id = "hs-eu-decline-button")
    private WebElement closeCookieWindowButton;

    @FindBy(className = "cart-empty")
    private WebElement cartMessageBlock;

    @FindBy(xpath = "//table/tbody/tr/td/div[@class='product-item-details']/strong")//xpath without wrapper duplicate
    private List<WebElement> cartItemInfo;

    @FindBy(xpath="//a[@class='action action-delete' and contains(.,'Remove item')]")
    private List<WebElement> removeItemButton;

    private By cartItem = By.xpath("//table/tbody/tr/td/div[@class='product-item-details']/strong");//that xpath because of wrapper duplicate

    private By cartMessage = By.xpath("//div[@class='cart-empty']");

    private By acceptDelete = By.xpath("//button[@class='action-primary action-accept']");

    private By removeItem = By.xpath("//a[@class='action action-delete' and contains(.,'Remove item')]");

    public CasioCartPage(WebDriver driver){
        super(driver);
    }

    public String getCartInfo(){
         Waits.getWebElementUntilWait(driver, cartItem);
         String listOfNameAllItemsInCart = "";
         for(WebElement i : cartItemInfo){
             listOfNameAllItemsInCart += i.getText() + "\n";
         }
         System.out.println("Text:\n" + listOfNameAllItemsInCart);
        return listOfNameAllItemsInCart;
    }

    /*public boolean isCartEmpty(){
        Waits.getWebElementUntilWait(driver, cartMessage);
        if(cartMessageBlock.isDisplayed()){
            return true;
        }else return false;
    }

    public String checkCartMessage(){
        if(isCartEmpty()){
            System.out.println(cartMessageBlock.getText());
            return cartMessageBlock.getText();
        }
        else return "ERROR EXCEPTION";
    }*/

    public boolean deleteItemFromCart(){
        Waits.getWebElementUntilWait(driver, removeItem);
        if(!removeItemButton.isEmpty()){
            System.out.println("Remove element count  = " + removeItemButton.size() + " " + cartItemInfo.size());
            while(removeItemButton.size() > 0){
                Waits.getWebElementUntilWait(driver, removeItem);
                removeItemButton.get(0).click();
                System.out.println("Remove element count  = " + removeItemButton.size());
                Waits.getWebElementUntilClickableWait(driver,acceptDelete);
                WebElement acceptDeleteButton = driver.findElement(acceptDelete);
                acceptDeleteButton.click();
            }
            System.out.println("Remove element count  = " + removeItemButton.size());
        }
        return cartItemInfo.size() == 0;
    }
    public boolean isCartEmpty(){
        return cartItemInfo.isEmpty();
    }
    public void changeQuantityOfElementToTwo(){
        int quantityOfElements = 2;
        System.out.println("changeQuantityOfElementToTwo. Thread id is: " + Thread.currentThread().getId());
        WebElement quantitiesOfItemInCart;
        quantitiesOfItemInCart = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='control qty']/input")));
        quantitiesOfItemInCart.clear();
        quantitiesOfItemInCart.sendKeys(Integer.toString(quantityOfElements));
        //Thread.sleep(3000);
        new Waits().waitUntilPageLoad(driver);
    }

    @Override
    public CasioCartPage openPage(){
        driver.get(CASIO_ITEM_PAGE_URL);
        return this;
    }
}

