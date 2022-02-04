package ru.bellintegrator.base;

import common.CommonActions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);

//    @AfterEach
//    public void close(){
//        driver.quit();
//    }
}
