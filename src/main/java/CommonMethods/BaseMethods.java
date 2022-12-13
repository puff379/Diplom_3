package CommonMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseMethods {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseMethods(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //метод для клика на элементы
    public void customClick(By element) {
        WebElement webElement = driver.findElement(element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        webElement.click();
    }

    //метод для заполнения полей
    public void customInput(By element, String words) {

        WebElement webElement = driver.findElement(element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        webElement.click();
        webElement.sendKeys(words);
    }


}
