package gui_HrSystem.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;
import java.util.List;


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
    protected String getTest(By locator){

        ExplicitWaitUntilElementVisibility(locator);
        String text= driver.findElement(locator).getText();
        return text;
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
   /* public static void untilPageReadyState(WebDriver webDriver, Long timeOutInSeconds)
    {
        wait2.until(webDriver, timeOutInSeconds, (function) -> {
            String isPageLoaded = String.valueOf(((JavascriptExecutor) webDriver).executeScript("return document.readyState"));
            if (isPageLoaded.equals("complete")) {
                return true;
            } else {
                System.out.println("Document is loading");
                return false;
            }
        });


    }*/
    }
