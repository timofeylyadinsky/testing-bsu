package test;

import driver.DriverSingleton;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class CommonConditions {
    protected WebDriver driver;

    @BeforeMethod//(alwaysRun = true)
    public void browserSetUp(){
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod//(alwaysRun = true)
    public void browserTearDown(){
        DriverSingleton.closeBrowser();
    }
}