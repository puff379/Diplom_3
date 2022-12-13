package Page;

import CommonMethods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseMethods {

    //ссылка на регистрацию
    private By regLink = By.className("Auth_link__1fOlj");
    //поле ввода email
    private By emailInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    //поле ввода пароля
    private By passwordInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    //кнопка Войти
    private By autorizationButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    //ссылка на восстановление пароля
    private By restorePassLink = By.xpath("//*[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //клик по ссылке на регистрацию
    public void regButtonClick() {
        customClick(regLink);
    }
    //метод для ввода email
    public void emailInputFill (String email) {
        customInput(emailInput, email);
    }
    //метод для ввода пароля
    public void passwordInputFill (String password) {
        customInput(passwordInput, password);
    }
    //клик на кнопку Войти
    public void autorizationButtonClick() {
        customClick(autorizationButton);
    }
    //клик на восстановление пароля
    public void restorePassClick() {
        customClick(restorePassLink);
    }
    //ожидание загрузки страницы авторизации
    public void loginPageIsLoad () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(regLink));
    }
    //метод для авторизации
    public void fullLogin(String email, String password) {
        emailInputFill(email);
        passwordInputFill(password);
        autorizationButtonClick();
    }
}
