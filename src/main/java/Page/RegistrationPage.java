package Page;

import CommonMethods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BaseMethods {

    //поле ввода имени
    private By nameArea = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    //поле ввода email
    private By emailArea = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    //поле ввода пароля
    private By passwordArea = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input");
    //кнопка Зарегистрироваться
    private By regButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    //ссылка на вход
    private By signInLink = By.xpath("//*[text()='Войти']");

    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    //метод ввода имени
    public void inputName(String name) {
        customInput(nameArea, name);
    }
    //метод ввода email
    public void inputEmail(String email) {
        customInput(emailArea, email);
    }
    //метод ввода пароля
    public void inputPassword(String password) {
        customInput(passwordArea, password);
    }
    //клик по кнопке Зарегистрироваться
    public void regButtonClick() {
        customClick(regButton);
    }
    //клик по ссылке на вход
    public void signInLincClick() {
        customClick(signInLink);
    }
    //метод для регстрации
    public void fullRegistration(String name, String email, String password) {
        inputName(name);
        inputEmail(email);
        inputPassword(password);
        regButtonClick();
    }
    //ожидание загрузки страницы регистрации
    public void regPageIsLoaded () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameArea));
    }

}
