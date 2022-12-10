package test;

import model.Item;
import org.testng.annotations.Test;
//import org.junit.jupiter.api.Test;
import page.CasioCartPage;
import page.CasioItemPage;
import service.ItemCreator;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
public class CartTest extends CommonConditions{


    private final String emptyCartMessage = "You have no items in your shopping basket.";

    //@Test
    public void addItemToCart(){
        long id = Thread.currentThread().getId();
        System.out.println("addItemToCart start. Thread id is: " + id);
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

    //@Test
    public void checkEmptyCart(){
        long id = Thread.currentThread().getId();
        System.out.println("checkEmptyCart start. Thread id is: " + id);
        Boolean cartIsEmtpy = new CasioCartPage(driver)
                .openPage()
                .isCartEmpty();
        Boolean expectedEmpty = true;
        System.out.println("addItemToCart2 end . Thread id is: " + id);
        assertThat(cartIsEmtpy)
                .isEqualTo(expectedEmpty);
    }

    //@Test
    public void deleteItemFromCart(){
        long id = Thread.currentThread().getId();
        System.out.println("deleteItemFromCart start. Thread id is: " + id);
        Item testItem = ItemCreator.withCredentialsFromProperty();
        new CasioItemPage(driver)
                .openPage()
                .addItemToCart()
                .goToCartPage();
        boolean numberOfItemsInCartEqualZero = new CasioCartPage(driver)
                .deleteItemFromCart();
        System.out.println("deleteItemFromCart end . Thread id is: " + id);
        Boolean cartIsEmtpy = new CasioCartPage(driver)
                .isCartEmpty();
        assertThat(numberOfItemsInCartEqualZero && cartIsEmtpy)
                .isTrue();
    }


    //@Test
    public void addTwoSimilarItemToCart(){
        long id = Thread.currentThread().getId();
        System.out.println("Change Quantity. Thread id is: " + id);
        Item testItem = ItemCreator.withCredentialsFromProperty();
        new CasioItemPage(driver)
                .openPage()
                .addItemToCart()
                .goToCartPage();
        new CasioCartPage(driver)
                .changeQuantityOfElementToTwo();
        System.out.println("Change quantity end. Thread id is: " + id);
        //assertThat(allProductNamesInCart).contains(testItem.getItemName());
    }

   // @Test
    public void test3(){
        long id = Thread.currentThread().getId();
        System.out.println("Sample test-method Two. Thread id is: " + id);
        Item testItem = ItemCreator.withCredentialsFromProperty();
        new CasioItemPage(driver)
                .openPage()
                .addItemToCart();
                //.goToCartPage();
    }
}
