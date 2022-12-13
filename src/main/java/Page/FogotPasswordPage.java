package Page;

import CommonMethods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FogotPasswordPage extends BaseMethods {
    //ссылка на Вход
    private By signInlink = By.xpath("//*[text()='Войти']");
    //надпись Восстановление пароля
    private By fogotPassHeader = By.xpath("//*[text()='Восстановление пароля']");

    public FogotPasswordPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //клик на ссылку Войти
    public void signInClick() {
        customClick(signInlink);
    }
    //метод ожидания загрузки страницы восстановления пароля
    public void fogotPassIsLoaded () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fogotPassHeader));
    }
}
