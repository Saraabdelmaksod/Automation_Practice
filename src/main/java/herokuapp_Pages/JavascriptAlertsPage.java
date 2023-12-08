package herokuapp_Pages;

import gui_HrSystem.pages.Base_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavascriptAlertsPage extends Base_Page {
    public JavascriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    private By javaScriptAlert= By.xpath("//button[@onclick=\"jsAlert()\"]");
    private By javaScriptPrompt=By.xpath("//button[@onclick=\"jsPrompt()\"]");
    private By sendAlert=By.id("result");



    public String clickOnAlert(){
        ExplicitWaitUntilElementClickable(javaScriptAlert);
        clickOnElement(javaScriptAlert);
        String alertText= driver.switchTo().alert().getText();
        return alertText;
    }

    public void clickAndSendKeyForAlert(String alertText) throws InterruptedException {
        ExplicitWaitUntilElementClickable(javaScriptPrompt);
        clickOnElement(javaScriptPrompt);
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys(alertText);
        driver.switchTo().alert().accept();
    }

    public String getSendAlertText(){

        return getTest(sendAlert);

    }

}
