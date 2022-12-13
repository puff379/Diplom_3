import CommonMethods.Variables;
import Page.ConstructorPage;
import Page.LoginPage;
import Page.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class RegistrationTests {

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

    //успешная регистрация
    @Test
    public void registration() {
        ConstructorPage constructorPage = new ConstructorPage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage regPage = new RegistrationPage(driver, wait);
        constructorPage.constructorPageIsLoad();
        constructorPage.clickAccountButton();
        loginPage.loginPageIsLoad();
        loginPage.regButtonClick();
        regPage.regPageIsLoaded();
        regPage.fullRegistration(variables.name, variables.email, variables.password);
    }
    //неудачная регистрация, пароль < 6 символов
    @Test
    public void failedRegistration() {
        ConstructorPage constructorPage = new ConstructorPage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage regPage = new RegistrationPage(driver, wait);
        constructorPage.constructorPageIsLoad();
        constructorPage.clickAccountButton();
        loginPage.loginPageIsLoad();
        loginPage.regButtonClick();
        regPage.regPageIsLoaded();
        regPage.fullRegistration(variables.name, variables.email, variables.incorrectPassword);
        String actualAnswer = driver.
                findElement(By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p")).getText();
        String exceptedQuestionText = "Некорректный пароль";
        assertEquals(actualAnswer, exceptedQuestionText);
    }
    @After
    public void quitBrowser() {
        driver.quit();
    }
}
