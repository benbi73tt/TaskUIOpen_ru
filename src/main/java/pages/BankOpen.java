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

    @FindBy(how = How.XPATH, using = "//tbody//tr[@class='main-page-exchange__row main-page-exchange__row--with-border']")
    List<WebElement> currency;

    public List<WebElement> getCurrency() {
        return currency;
    }

}
