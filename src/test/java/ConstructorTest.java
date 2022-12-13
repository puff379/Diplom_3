import CommonMethods.Variables;
import Page.ConstructorPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private Variables variables;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        //driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        driver.get("https://stellarburgers.nomoreparties.site/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        variables = new Variables();
    }

    //тест поочередного переключения вкладок
    @Test
    public void saucesTabClick() {
        ConstructorPage constructorPage = new ConstructorPage(driver, wait);
        constructorPage.constructorPageIsLoad();
        constructorPage.waitSauce();
        constructorPage.clickSaucesTab();
        constructorPage.waitSauce();
        constructorPage.clickFillingsTab();
        constructorPage.waitFilling();
        constructorPage.clickBunTab();
        constructorPage.waitBun();
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }
}
