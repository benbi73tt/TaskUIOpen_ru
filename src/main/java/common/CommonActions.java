package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static constant.ConstantTime.IMPLICIT_WAIT;

public class CommonActions {

    protected static WebDriver driver;

    public static WebDriver createDriver() {
//        System.setProperty("webdriver.chrome.driver","C:\\github\\QA\\driver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",System.getenv("CHROME_DRIVER"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        return driver;
    }
}
