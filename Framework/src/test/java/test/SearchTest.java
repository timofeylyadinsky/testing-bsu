package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import page.CasioHomePage;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class SearchTest extends CommonConditions{
    private final Logger logger = LogManager.getRootLogger();
    private final String messageForNullSearching = "Please try another search term...";

    @Test
    public void searchWatchesByParameter(){
        String searchNameOfItem = "f-91";
        logger.info("start search watches: " + searchNameOfItem);
        List<String> actualSearchResults = new CasioHomePage(driver)
                .openPage()
                .searchByNameResult(searchNameOfItem);
        assertThat(actualSearchResults)
                .allMatch(it -> it.contains(searchNameOfItem));
    }

    @Test
    public void searchWithInvalidText(){
        String invalidString = "wwwwwww";
        logger.info("start search invalid " + invalidString);
        new CasioHomePage(driver)
                .openPage()
                .searchByNameResult(invalidString);
        String message = new CasioHomePage(driver)
                .getEmptySearchMessage();
        assertThat(message)
                .contains(messageForNullSearching);

    }
}
