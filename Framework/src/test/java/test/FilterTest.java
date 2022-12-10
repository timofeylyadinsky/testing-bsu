package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import page.CasioCollectionPage;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterTest extends CommonConditions{
    private final Logger logger = LogManager.getRootLogger();
    @Test
    public void filterPriceAscending(){
        logger.info("Start filterPriceAsc Test");
        driver.get("https://www.casio.co.uk/watches-clocks/casio-collection?p=1&product_list_order=price_asc");
        CasioCollectionPage itemsPage = new CasioCollectionPage(driver);
        List<Double> pricesFromPage = itemsPage.getPriceList();
        System.out.println(pricesFromPage.toString());
        assertThat(pricesFromPage)
                .containsSequence(pricesFromPage.stream().sorted().collect(Collectors.toList()))
                .hasSize(pricesFromPage.stream().sorted().collect(Collectors.toList()).size());
    }
    @Test
    public void filterPriceDescending(){
        logger.info("start filterPriceDesc test");
        driver.get("https://www.casio.co.uk/watches-clocks/casio-collection?product_list_order=price_desc");
        CasioCollectionPage itemsPage = new CasioCollectionPage(driver);
        List<Double> pricesFromPage = itemsPage.getPriceList();
        System.out.println(pricesFromPage.toString());
        assertThat(pricesFromPage)
                .containsSequence(pricesFromPage
                        .stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()))
                .hasSize(pricesFromPage
                        .stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())
                        .size());
    }
}
