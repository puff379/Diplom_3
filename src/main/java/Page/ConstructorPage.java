package Page;

import CommonMethods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConstructorPage extends BaseMethods {

    //кнопка Личный Кабинет
    private By accountButton = By.xpath("//*[text()='Личный Кабинет']");
    //кнопка войти в аккаунт
    private By signInAccount = By.xpath("//*[text()='Войти в аккаунт']");
    //вкладка Булки
    private By bunTab = By.xpath("//h2[text()='Булки']");
    //вкладка Соусы
    private By saucesTab = By.xpath("//h2[text()='Соусы']");
    //вкладка Начинки
    private By fillingsTab = By.xpath("//h2[text()='Начинки']");
    //надпись Булки
    private By inscriptionBun = By.xpath("//span[text()='Булки']");
    //надпись Соусы
    private By inscriptionSauce = By.xpath("//span[text()='Соусы']");
    //Надпись Начинки
    private By inscriptionFillings = By.xpath("//span[text()='Начинки']");
    //надпись Соберите бургер
    private By mainPageHeader = By.xpath("//*[text()='Соберите бургер']");

    public ConstructorPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //нажать на кнопку Личный Кабинет
    public void clickAccountButton() {
        customClick(accountButton);
    }

    //кликнуть по вкладке Булки
    public void clickBunTab() {
        customClick(bunTab);
    }

    //кликнуть по вкладке Соусы
    public void clickSaucesTab() {
        customClick(saucesTab);
    }

    //кликнуть по вкладке Начинки
    public void clickFillingsTab() {
        customClick(fillingsTab);
    }

    //нажать на кнопку Войти а аккаунт
    public void clickSignInAccount() {
        customClick(signInAccount);
    }

    //ожидание загрузки главной страницы
    public void constructorPageIsLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPageHeader));
    }
    //ожидание загрузки надписи Соусы
    public void waitSauce() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inscriptionSauce));
    }
    //ожидание загрузки надписи Начинки
    public void waitFilling() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inscriptionFillings));
    }
    //ожидание загрузки надписи Булки
    public void waitBun() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inscriptionBun));
    }
}
