package gui_HrSystem.pages;

import org.openqa.selenium.*;

import java.time.Duration;

public class Attendance_Page extends Base_Page{
    public Attendance_Page(WebDriver driver) {
        super(driver);
    }

  private By dateBtn= By.xpath("//div[@class='oxd-date-input']//i");
    private By dataInput=By.xpath("(//input[@class='oxd-input oxd-input--active'])[1]");
    private By timeInput=By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
    private By clockLogo=By.xpath("//i[@class='oxd-icon bi-clock oxd-time-input--clock']");
    private By hours=By.cssSelector("[class*='oxd-time-hour-input-text']");
    private By mins=By.cssSelector("[class*='oxd-time-minute-input-text']");
    private By pm=By.xpath("(//div[@class='oxd-time-period-label'])[2]");
    private By hour=By.xpath("//input[@class='oxd-input oxd-input--active oxd-time-hour-input-text']");
    private By minute=By.xpath("//input[@class='oxd-input oxd-input--active oxd-time-minute-input-text']");
    private By pm2=By.xpath("(//div[@class='oxd-time-period-label'])[2]");

    public void enterDate(String date) {
      /*  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement ele=driver.findElement(dataInput);
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", ele);
        sendKey(dataInput, date);*/

     //another Solution to enter date ->> remove placeholder then send keys
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       sendKey(dataInput, String.valueOf(Keys.DELETE));
      // driver.findElement(dataInput).sendKeys();
       sendKey(dataInput, date);

    }

    public void test(){
        WebElement ele=driver.findElement(clockLogo);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", ele);
        clickOnElement(clockLogo);
        sendKey(hour, String.valueOf(Keys.DELETE));
        sendKey(hour, "10");
        sendKey(minute, String.valueOf(Keys.DELETE));
        sendKey(minute, "10");
        clickOnElement(pm2);

    }
    public void enterTime(String time) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(timeInput).clear();
      // sendKey(timeInput, String.valueOf(Keys.DELETE));
        sendKey(timeInput, time);

       /* driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        ExplicitWaitUntilElementClickable(clockLogo);
        clickOnElement(clockLogo);
        sendKey(hours, String.valueOf(Keys.DELETE));
        sendKey(hours, "3");
        sendKey(mins, String.valueOf(Keys.DELETE));
        sendKey(mins, "30");
        clickOnElement(pm);*/


    }
}
