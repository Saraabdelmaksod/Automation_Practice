package herokuapp_Pages;

import gui_HrSystem.pages.Base_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends Base_Page {
    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    private By box= By.id("hot-spot");

    public void rightClickBox(){
        Actions action = new Actions(driver);
        WebElement eleBox= driver.findElement(box);
        action.contextClick(eleBox).perform();
    }
    public void  acceptTheAlertDisplayed(){
       driver.switchTo().alert().accept();

    }
    public void  dismissTheAlertDisplayed(){
        driver.switchTo().alert().dismiss();

    }
}
