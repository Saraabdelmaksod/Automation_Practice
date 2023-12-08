package herokuapp_Pages;

import gui_HrSystem.pages.Base_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicAuthPage extends Base_Page {
    public BasicAuthPage(WebDriver driver) {
        super(driver);
    }

  private By successMessage= By.xpath("//div/p");

    public void setUserAndPassword(String user, String pass){

        driver.get("https://"+user+":"+pass+"@the-internet.herokuapp.com/basic_auth");
    }

    public String getSuccessMessage(){
        ExplicitWaitUntilElementVisibility(successMessage);
        String message= driver.findElement(successMessage).getText();
        return message;
    }

}
