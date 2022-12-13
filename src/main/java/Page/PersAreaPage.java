package Page;

import CommonMethods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersAreaPage extends BaseMethods {
    //надпись Профиль
    private By persAreaHeader = By.xpath("//*[text()='Профиль']");
    //кнопка Конструктор
    private By constructorButton = By.xpath("//*[text()='Конструктор']");
    //кнопка Выход
    private By signOutButton = By.xpath("//*[text()='Выход']");

    public PersAreaPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //метод ожидания загрузки Личного кабинета
    public void persAreaPageIsLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(persAreaHeader));
    }
    //клик по кнопке Конструктор
    public void clickConstructorButton() {
        customClick(constructorButton);
    }
    //клик по кнопке выхода
    public void clickSignOut() {
        customClick(signOutButton);
    }
}
