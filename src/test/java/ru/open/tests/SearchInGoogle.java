package ru.open.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TestModule;
import ru.open.base.BaseTest;

import java.time.Duration;
import java.util.stream.Stream;

import static constant.ConstantTitle.BANK_OPEN;
import static constant.ConstantURL.GOOGLE_PAGE;

public class SearchInGoogle extends BaseTest {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    protected TestModule testModule = PageFactory.initElements(driver, TestModule.class);
    private int size = driver.getWindowHandles().size();


    @Test
    public void searchOpen() {
        testModule.open(GOOGLE_PAGE);
        testModule.findAndPressEnter("Открытие");
        testModule.openBankPage();

        waitWindow();
        switchTo(BANK_OPEN);
        Assertions.assertEquals(driver.getTitle(), BANK_OPEN);
        compareBuyAndSell();
    }


    public Stream<Boolean> compareBuyAndSell() {
       return testModule.getCurrency().stream().map(x -> {
            double buy = Double.parseDouble(x[0].replaceAll(",", "."));
            double sale = Double.parseDouble(x[1].replaceAll(",", "."));
            Assertions.assertTrue(buy < sale);
            return buy < sale;
        });
    }

    public String switchTo(String str) {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
            if (driver.getTitle().equals(str)) {
                return str;
            }
        }
        return null;
    }


    public void waitWindow() {
        wait.until(((ExpectedCondition<Boolean>) d -> driver.getWindowHandles().size() > size));
        size = driver.getWindowHandles().size();
    }

}
