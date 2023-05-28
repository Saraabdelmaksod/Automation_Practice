package gui_HrSystems.tests;

import gui_HrSystem.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
@Test
public class LoginTest_ScenarioTestNG1 extends Base_Test {




    public void loginSuccessfully(){
        LoginPageObj=new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        LoginPageObj.loginWithValidData("Admin", "admin123");
    }

    public void loginSuccessfully2(){
       System.out.println("testlllk");
    }

}
