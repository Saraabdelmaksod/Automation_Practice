package gui.tests_HR;

import gui_HrSystem.pages.LoginPage;
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
