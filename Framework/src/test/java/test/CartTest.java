package test;

import model.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.junit.jupiter.api.Test;
import page.CasioCartPage;
import page.CasioItemPage;
import service.ItemCreator;
import utils.Waits;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
public class CartTest extends CommonConditions{

    private final Logger logger = LogManager.getRootLogger();
    private final String emptyCartMessage = "You have no items in your shopping basket.";
    private final String secondCartMessage = "Click here to continue shopping.";

    @Test
    public void addItemToCart(){
        long id = Thread.currentThread().getId();
        logger.info("addItemToCart start. Thread id is: " + id);
        Item testItem = ItemCreator.withCredentialsFromProperty();
        new CasioItemPage(driver)
                .openPage()
                .addItemToCart()
                .goToCartPage();
        String allProductNamesInCart = new CasioCartPage(driver)
              .getCartInfo();
        System.out.println("addItemToCart end . Thread id is: " + id);
        assertThat(allProductNamesInCart)
                .contains(testItem.getItemName());
    }

    @Test
    public void checkEmptyCart(){
        long id = Thread.currentThread().getId();
        logger.info("checkEmptyCart start. Thread id is: " + id);
        Boolean cartIsEmtpy = new CasioCartPage(driver)
                .openPage()
                .isCartEmpty();
        Boolean expectedEmpty = true;
        assertThat(cartIsEmtpy)
                .isEqualTo(expectedEmpty);
    }

    @Test
    public void deleteItemFromCart(){
        long id = Thread.currentThread().getId();
        logger.info("deleteItemFromCart start. Thread id is: " + id);
        Item testItem = ItemCreator.withCredentialsFromProperty();
        new CasioItemPage(driver)
                .openPage()
                .addItemToCart()
                .goToCartPage();
        boolean numberOfItemsInCartEqualZero = new CasioCartPage(driver)
                .deleteItemFromCart();
        boolean cartIsEmtpy = new CasioCartPage(driver)
                .isCartEmpty();
        assertThat(numberOfItemsInCartEqualZero && cartIsEmtpy)
                .isTrue();
    }

    @Test
    public void checkMessageInEmptyCart(){
        long id = Thread.currentThread().getId();
        logger.info("checkMessageInEmptyCart. Thread id is: " + id);
        String messageFromCart = new CasioCartPage(driver)
                .openPage()
                .checkCartMessage();
        assertThat(messageFromCart)
                .contains(emptyCartMessage)
                .contains(secondCartMessage);

    }

    @Test
    public void addTwoSimilarItemToCart(){
        long id = Thread.currentThread().getId();
        logger.info("addTwoSimilarItemToCart. Thread id is: " + id);
        Item testItem = ItemCreator.withCredentialsFromProperty();
        new CasioItemPage(driver)
                .openPage()
                .addItemToCart();
        driver.navigate().refresh();
        new CasioItemPage(driver)
                .addItemToCart()
                .goToCartPage();
        int countOfItem = new CasioCartPage(driver)
                .getCountOfCurrentItem(testItem);
        double subtotalPriceOfItem = new CasioCartPage(driver)
                .getSubtotalPrice(testItem);
        double currentPriceOfItem = new CasioCartPage(driver)
                .getItemPrice(testItem);
        int expectedCount = 2;
        assertThat(countOfItem)
                .as("Check subtotal price")
                .isEqualTo((int) (subtotalPriceOfItem / currentPriceOfItem));
        assertThat(countOfItem)
                .as("check by expected 2 elements")
                .isEqualTo(expectedCount);
    }
}
