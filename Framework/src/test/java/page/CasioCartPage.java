package page;

import model.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waits;

import java.util.List;

public class CasioCartPage extends AbstractPage{

    public static String CASIO_CART_PAGE_URL = "https://www.casio.co.uk/checkout/cart/";
    private final Logger logger = LogManager.getRootLogger();

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
         logger.info("Items in cart: " + listOfNameAllItemsInCart);
        return listOfNameAllItemsInCart;
    }

    public String checkCartMessage(){
        if(isCartEmpty()){
            logger.info(cartMessageBlock.getText());
            return cartMessageBlock.getText();
        }
        else return null;
    }

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
        logger.info("remove items from cart");
        return cartItemInfo.size() == 0;
    }
    public boolean isCartEmpty(){
        return cartItemInfo.isEmpty();
    }

    public int getCountOfCurrentItem(Item currentItem){
        By inputBoxForCurrentElement = By.xpath("//strong[@class='product-item-name' and contains(.,'"+ currentItem.getItemName()+"')]/../../../td[@class='col qty']/div/div/input");
        WebElement quantityBox = driver.findElement(inputBoxForCurrentElement);
        logger.info("find quantity of items: " + currentItem.getItemName()
                + " quantity: "
                + quantityBox.getAttribute("value"));
        return Integer.parseInt(quantityBox.getAttribute("value").toString());
    }

    public double getSubtotalPrice(Item currentItem){
        WebElement subtotalText = Waits.getWebElementUntilWait(driver, By.xpath("//strong[@class='product-item-name' and contains(.,'"
                + currentItem.getItemName()+
                "')]/../../../td[@class='col subtotal']/span/span[@class='cart-price']/span[@class='price']"));
        String currentPriceOfMoreItemText = subtotalText.getText().toString();

        double currentPriceOfMoreItem = Double.parseDouble(currentPriceOfMoreItemText.substring(1));
        logger.info("find price for items: " + currentItem.getItemName() + " price: " + currentPriceOfMoreItem);
        return currentPriceOfMoreItem;
    }

    public double getItemPrice(Item currentItem){
        WebElement priceText = Waits.getWebElementUntilWait(driver, By.xpath("//strong[@class='product-item-name' and contains(.,'"
                + currentItem.getItemName()+
                "')]/../../../td[@class='col price']/span/span[@class='cart-price']/span[@class='price']"));
        String currentPriceOfOneItemText = priceText.getText().toString();
        double currentPriceOfOneItem = Double.parseDouble(currentPriceOfOneItemText.substring(1));
        logger.info("find price for item: " + currentItem.getItemName() + " price: " + currentPriceOfOneItemText);
        return currentPriceOfOneItem;
    }

    @Override
    public CasioCartPage openPage(){
        driver.get(CASIO_CART_PAGE_URL);
        logger.info("Open Cart page: " + CASIO_CART_PAGE_URL);
        return this;
    }
}

