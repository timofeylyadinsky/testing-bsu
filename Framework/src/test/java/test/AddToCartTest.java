package test;

import model.Item;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CasioCartPage;
import page.CasioItemPage;
import service.ItemCreator;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
public class AddToCartTest extends CommonConditions{

    @Test
    public void addItemToCart(){
        Item testItem = ItemCreator.withCredentialsFromProperty();
        new CasioItemPage(driver)
                .openPage()
                .addItemToCart()
                .goToCartPage();
        String actual = new CasioCartPage(driver)
              .getCartInfo();
        assertThat(actual).contains(testItem.getItemName());
    }
}
