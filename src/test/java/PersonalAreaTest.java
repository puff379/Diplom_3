import CommonMethods.Variables;
import Page.ConstructorPage;
import Page.LoginPage;
import Page.PersAreaPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAreaTest {
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
        driver.get("https://stellarburgers.nomoreparties.site/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        variables = new Variables();
    }
    //переход в Личный кабинет
    @Test
    public void goToPersArea() {
        ConstructorPage constructorPage = new ConstructorPage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);
        PersAreaPage persAreaPage = new PersAreaPage(driver, wait);
        constructorPage.constructorPageIsLoad();
        constructorPage.clickSignInAccount();
        loginPage.loginPageIsLoad();
        loginPage.fullLogin(variables.existingUser, variables.password);
        constructorPage.constructorPageIsLoad();
        constructorPage.clickAccountButton();
        persAreaPage.persAreaPageIsLoad();
    }
    //переход из Личного кабинета в конструктор
    @Test
    public void goToConstructor() {
        ConstructorPage constructorPage = new ConstructorPage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);
        PersAreaPage persAreaPage = new PersAreaPage(driver, wait);
        constructorPage.constructorPageIsLoad();
        constructorPage.clickSignInAccount();
        loginPage.loginPageIsLoad();
        loginPage.fullLogin(variables.existingUser, variables.password);
        constructorPage.constructorPageIsLoad();
        constructorPage.clickAccountButton();
        persAreaPage.persAreaPageIsLoad();
        persAreaPage.clickConstructorButton();
        constructorPage.constructorPageIsLoad();
    }
    @Test
    public void signOut() {
        ConstructorPage constructorPage = new ConstructorPage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);
        PersAreaPage persAreaPage = new PersAreaPage(driver, wait);
        constructorPage.constructorPageIsLoad();
        constructorPage.clickSignInAccount();
        loginPage.loginPageIsLoad();
        loginPage.fullLogin(variables.existingUser, variables.password);
        constructorPage.constructorPageIsLoad();
        constructorPage.clickAccountButton();
        persAreaPage.persAreaPageIsLoad();
        persAreaPage.clickSignOut();
        loginPage.loginPageIsLoad();
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }
}
