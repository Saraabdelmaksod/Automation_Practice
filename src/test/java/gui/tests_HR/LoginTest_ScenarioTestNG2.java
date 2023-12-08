package gui.tests_HR;

import org.testng.Assert;
import org.testng.annotations.*;


public class LoginTest_ScenarioTestNG2 extends Base_Test{
    @Test(priority = 0)
    public void loginSuccessfully()
    {
        LoginPageObj.loginWithValidData("Admin", "admin123");
        MainPageObj.logout();

    }
    @Test(priority = 1,enabled = false)
    public void loginFailedWithInvalidPassword()
    {
        LoginPageObj.loginWithValidData("Admin", "admin12");
        // message will be displayed when test case is fail
        Assert.assertTrue(MainPageObj.logOutDisplayed(), " Login is failed");
    }
    @Test(priority = 2)
    public void TestErrorMessageDisplayingWhenLoginWithInvalidPassword()
    {
        LoginPageObj.loginWithValidData("Admin", "admin12");
        // message will be displayed when test case is fail
        Assert.assertEquals(LoginPageObj.getErrorMessageForInvalidCredentials(), "Invalid credentials", "Error message not displayed when enter invalid Credentials");

    }



}
