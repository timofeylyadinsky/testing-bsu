package test;

import model.Item;
import org.testng.annotations.Test;
//import org.junit.jupiter.api.Test;
import page.CasioCartPage;
import page.CasioItemPage;
import service.ItemCreator;

import static org.assertj.core.api.Assertions.assertThat;
public class CartTest extends CommonConditions{

    @Test
    public void addItemToCart(){
        long id = Thread.currentThread().getId();
        System.out.println("Sample test-method One. Thread id is: " + id);
        Item testItem = ItemCreator.withCredentialsFromProperty();
        new CasioItemPage(driver)
                .openPage()
                .addItemToCart()
                .goToCartPage();
        String allProductNamesInCart = new CasioCartPage(driver)
              .getCartInfo();
        System.out.println("Sample test-method One. Thread id is: " + id);
        assertThat(allProductNamesInCart).contains(testItem.getItemName());
    }
    //@Test
    public void test3(){
        long id = Thread.currentThread().getId();
        System.out.println("Sample test-method Two. Thread id is: " + id);
        Item testItem = ItemCreator.withCredentialsFromProperty();
        new CasioItemPage(driver)
                .openPage();
    }
}
