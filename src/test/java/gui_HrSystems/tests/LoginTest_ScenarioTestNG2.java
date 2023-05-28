package gui_HrSystems.tests;

import org.testng.annotations.*;


public class LoginTest_ScenarioTestNG2 extends Base_Test{



    @Test(priority = 0)
    public void loginSuccessfully()
    {
        LoginPageObj.loginWithValidData("Admin", "admin123");
    }
    @Test(priority = 1)
    public void logout()
    {
        MainPageObj.logout();

    }



}
