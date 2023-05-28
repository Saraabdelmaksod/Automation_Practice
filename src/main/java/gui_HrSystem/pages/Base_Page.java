package gui_HrSystem.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class Base_Page {
    public static WebDriver driver;
    public WebDriverWait wait2;

    public Base_Page(WebDriver driver)
    {
        this.driver=driver;
    }

    protected void clickOnElement(By locator)
    {
        driver.findElement(locator).click();
    }
    protected void sendKey(By locator, String text)
    {
        driver.findElement(locator).sendKeys(text);
    }



    protected void fluentWaitUntilVisibility(By locator1) {
        Wait<WebDriver> wait= new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);

        WebElement element=wait.until(new Function<WebDriver, WebElement>()
        {
            public WebElement apply(WebDriver driver ) {
                return driver.findElement(locator1);
            }
        });
    }

    protected void ExplicitWaitUntilElementVisibility(By locator)
    {
        wait2=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void ExplicitWaitUntilElementClickable(By locator)
    {
        wait2=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait2.until(ExpectedConditions.elementToBeClickable(locator));
    }



}
