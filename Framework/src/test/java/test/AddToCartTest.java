package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CasioCartPage;
import page.CasioItemPage;

public class AddToCartTest extends CommonConditions{

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
}
