package gui.tests_HR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cross_Browser_Test {
    public WebDriver driver;
    @Test
    @Parameters ({"URL", "BrowserType"})
    public void openWebsite(String url , String browserType) {
        if(browserType.equalsIgnoreCase("Internet Explorer")){
            driver=new InternetExplorerDriver();

        } else if (browserType.equalsIgnoreCase("Firefox")) {
            driver=new FirefoxDriver();
        }
        else if (browserType.equalsIgnoreCase("Chrome")) {
            driver=new ChromeDriver();}

         driver.manage().window().maximize();
         driver.get(url);
         System.out.println("\n" + "open " +browserType);
         System.out.println(" " +  driver.getTitle());

         driver.quit();


    }
}
