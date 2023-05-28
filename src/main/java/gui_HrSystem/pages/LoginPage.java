package gui_HrSystem.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base_Page{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By useName= By.name("username");
    private By password=By.name("password");
    private By login_Btn=By.cssSelector("[class*='oxd-button']");

    public void loginWithValidData(String name, String userPassword)
    {
        ExplicitWaitUntilElementVisibility(useName);
        sendKey(useName, name);
        sendKey(password, userPassword);
        clickOnElement(login_Btn);
    }




}
