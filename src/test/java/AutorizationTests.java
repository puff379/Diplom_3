import CommonMethods.Variables;
import Page.ConstructorPage;
import Page.FogotPasswordPage;
import Page.LoginPage;
import Page.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutorizationTests {

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
    //авторизация с главной страницы
    @Test
    public void autorizationMainPage() {
        ConstructorPage constructorPage = new ConstructorPage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);
        constructorPage.constructorPageIsLoad();
        constructorPage.clickSignInAccount();
        loginPage.loginPageIsLoad();
        loginPage.fullLogin(variables.existingUser, variables.password);
        constructorPage.constructorPageIsLoad();
    }
    //авторизация через личный кабинет
    @Test
    public void autorizationPersonalArea() {
        ConstructorPage constructorPage = new ConstructorPage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);
        constructorPage.constructorPageIsLoad();
        constructorPage.clickAccountButton();
        loginPage.loginPageIsLoad();
        loginPage.fullLogin(variables.existingUser, variables.password);
        constructorPage.constructorPageIsLoad();
    }
    //авторизация со страницы регистрации
    @Test
    public void autorizationFromRegistration() {
        ConstructorPage constructorPage = new ConstructorPage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage regPage = new RegistrationPage(driver, wait);
        constructorPage.constructorPageIsLoad();
        constructorPage.clickAccountButton();
        loginPage.loginPageIsLoad();
        loginPage.regButtonClick();
        regPage.regPageIsLoaded();
        regPage.signInLincClick();
        loginPage.loginPageIsLoad();
        loginPage.fullLogin(variables.existingUser, variables.password);
        constructorPage.constructorPageIsLoad();
    }
    //авторизация со страницы восстановления пароля
    @Test
    public void autorizationFromFogotPassPage() {
        ConstructorPage constructorPage = new ConstructorPage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage regPage = new RegistrationPage(driver, wait);
        FogotPasswordPage passwordPage = new FogotPasswordPage(driver, wait);
        constructorPage.constructorPageIsLoad();
        constructorPage.clickAccountButton();
        loginPage.loginPageIsLoad();
        loginPage.restorePassClick();
        passwordPage.fogotPassIsLoaded();
        passwordPage.signInClick();
        regPage.regPageIsLoaded();
        regPage.signInLincClick();
        loginPage.loginPageIsLoad();
        loginPage.fullLogin(variables.existingUser, variables.password);
        constructorPage.constructorPageIsLoad();
    }
    @After
    public void quitBrowser() {
        driver.quit();
    }
}
