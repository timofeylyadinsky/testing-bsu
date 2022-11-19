package first_test;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;


public class CustomConditions {
    public static ExpectedCondition<Boolean> jQueryAJAXsCompleted(){
        return new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver){
                return (Boolean) ((JavascriptExecutor)driver).executeScript("return ((window.jQuery != 'undefined') && (jQuery.active == 0) && (document.readyState == 'complete')); ");
            }
        };
    }
}
