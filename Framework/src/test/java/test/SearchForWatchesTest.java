package test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page.CasioHomePage;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class SearchForWatchesTest extends CommonConditions{

    @Test
    public void searchWatchesByParameter(){
        String searchNameOfItem = "f-91";
        List<String> actualSearchResults = new CasioHomePage(driver)
                .openPage()
                .searchByNameResult(searchNameOfItem);
        assertThat(actualSearchResults)
                .allMatch(it -> it.contains(searchNameOfItem));
    }
}
