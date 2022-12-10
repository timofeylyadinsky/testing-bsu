package test;

import driver.DriverSingleton;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class CommonConditions {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp(){
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        System.out.println("Close browser. Thread id is: " + Thread.currentThread().getId());
        DriverSingleton.closeBrowser();
    }
}