package ru.bellintegrator.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BankOpen;
import pages.HomeGoogle;
import ru.bellintegrator.base.BaseTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static constant.ConstantTitle.BANK_OPEN;
import static constant.ConstantURL.GOOGLE_PAGE;

public class SearchInGoogle extends BaseTest {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    ;
    protected HomeGoogle homeGoogle = PageFactory.initElements(driver, HomeGoogle.class);
    protected BankOpen bankOpen = PageFactory.initElements(driver, BankOpen.class);
    private int size = driver.getWindowHandles().size();


    @Test
    public void SearchOpen() {
        homeGoogle.open(GOOGLE_PAGE);
        homeGoogle.findAndPressEnter("Открытие");


        driver.findElement(By.xpath("//a[contains(@href,'https://www.open.ru')]//cite")).click();
        waitWindow();
        driver.findElement(By.xpath("//a[contains(@href,'https://www.championat.com')]//cite")).click();

        waitWindow();
        switchTo(BANK_OPEN);

        Assertions.assertEquals(driver.getTitle(), BANK_OPEN);
        buyAndSellCurrency();
    }


    public void buyAndSellCurrency() {
        bankOpen.getCurrency().stream().forEach(x -> {
            String name = x.findElement(By.xpath(".//span[@class='ant-typography open-ui-text open-ui-text-theme-default largeText main-page-exchange__currency-name']")).getText();
            String buy = x.findElement(By.xpath(".//td[2]//span[@class='main-page-exchange__rate']")).getText();
            String sale = x.findElement(By.xpath(".//td[4]//span[@class='main-page-exchange__rate']")).getText();
            System.out.println(name + " " + buy + " Покупка " + " / " + sale + " Продажа");
            double dBuy = Double.parseDouble(buy.replaceAll(",","."));
            double dSale = Double.parseDouble(sale.replaceAll(",","."));
            Assertions.assertTrue(dBuy < dSale);
        });
    }

    public String switchTo(String str) {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
            System.out.println(driver.getTitle());
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
