package herokuapp_Pages;

import gui_HrSystem.pages.Base_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Base_Page {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By basic_authUrl= By.partialLinkText("Basic Auth");
    private By context_Menu=By.partialLinkText("Context Menu");
    private By JavaScript_alerts =By.partialLinkText("JavaScript Alerts");


    public BasicAuthPage openBasic_authPage(){

        ExplicitWaitUntilElementVisibility(basic_authUrl);
        clickOnElement(basic_authUrl);
        return new BasicAuthPage(driver);
    }

    public ContextMenuPage openContextMenuPage(){
        ExplicitWaitUntilElementVisibility(context_Menu);
        clickOnElement(context_Menu);
        return new ContextMenuPage(driver);
    }
    public JavascriptAlertsPage openJavascriptAlertsPage(){
        ExplicitWaitUntilElementClickable(JavaScript_alerts);
        clickOnElement(JavaScript_alerts);
        return new JavascriptAlertsPage(driver);
    }
}
