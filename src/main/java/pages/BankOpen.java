package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class BankOpen extends BasePage {
    public BankOpen(WebDriver driver) {
        super(driver);
    }

    public WebElement getUSD() {
        return USD;
    }

    public List<WebElement> getCurrency() {
        return currency;
    }

    @FindBy(how = How.XPATH, using = "//tbody//tr[@class='main-page-exchange__row main-page-exchange__row--with-border']")
    List<WebElement> currency;

    @FindBy(xpath = "//span[@class=\"ant-typography open-ui-text open-ui-text-theme-default largeText main-page-exchange__currency-name\"]")
    WebElement USD;

    WebElement BankSells;

    WebElement BankBuys;

    //todo Сделать класс с объектами валюты , покупки, продажи и лист для объектов

}
