package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class TestModule extends BasePage {

    public TestModule(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='q' and @title='Поиск']")
    WebElement searchField;

    @FindBy(xpath = "//div[@class='FPdoLc lJ9FBc']//input[@type='submit' and @class='gNO89b']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='lJ9FBc']//input[@type='submit' and @class='gNO89b']")
    WebElement searchButtonInJSController;

    @FindBy(xpath ="//a[contains(@href,'https://www.open.ru')]//cite")
    WebElement bankOpen;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@class='main-page-exchange__row main-page-exchange__row--with-border']")
    List<WebElement> currency;

    By buy = By.xpath(".//td[2]//span[@class='main-page-exchange__rate']");
    By sell = By.xpath(".//td[4]//span[@class='main-page-exchange__rate']");



    public List<String[]> getCurrency() {
        List<String[]> buyAndSell = new ArrayList();
        currency.stream().forEach(x -> {
            buyAndSell.add(new String[]
                    { x.findElement(buy).getText(),
                     x.findElement(sell).getText()});
        });
        return buyAndSell;
    }


    public void findAndPressEnter(String keyFind){
        searchField.click();
        searchField.sendKeys(keyFind, Keys.ENTER);
    }

    public void openBankPage(){
        bankOpen.click();
    }

    public void findAndPressButton(String keyFind){
        searchField.click();
        searchField.sendKeys(keyFind);
        searchButtonInJSController.click();
    }
}
