package gui_HrSystem.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Base_Page {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    By logoutDroplist= By.className("oxd-userdropdown-tab");
    private  By logoutBtn=By.xpath("(//a[@class='oxd-userdropdown-link'])[4]");
    private By attendanceBtn= By.cssSelector("[class*='orangehrm-attendance-card-action']");




    public void logout(){
        ExplicitWaitUntilElementVisibility(logoutDroplist);
        clickOnElement(logoutDroplist);
        ExplicitWaitUntilElementClickable(logoutBtn);
        clickOnElement(logoutBtn);
    }
    public boolean logOutDisplayed(){
        return driver.findElement(logoutDroplist).isDisplayed();
    }
    public void clickOnAttendanceBtn(){
        ExplicitWaitUntilElementVisibility(attendanceBtn);

        clickOnElement(attendanceBtn);
    }


}
