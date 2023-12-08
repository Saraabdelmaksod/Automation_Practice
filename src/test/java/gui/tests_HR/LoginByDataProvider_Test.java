package gui.tests_HR;

import gui_HrSystem.pages.LoginPage;
import gui_HrSystem.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginByDataProvider_Test {

    public WebDriver driver;
    public LoginPage LoginPageObj;
    public MainPage MainPageObj;

    @Test(dataProvider = "login_Data")
    public void loginByDataProvider(String username, String password)
    {
        driver=new ChromeDriver();
        LoginPageObj =new LoginPage(driver);
        MainPageObj=new MainPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        LoginPageObj.loginWithValidData(username, password);
       // boolean actualResult=MainPageObj.logOutDisplayed();
       // Assert.assertTrue(actualResult, "Logout button not displayed");
        driver.quit();

    }
    @DataProvider(name="login_Data")
    public static Object[][] loginData(){
        Object[][] data=new Object[3][2];
        data[0][0]= "Admin" ;   data[0][1]= "admin123" ;
        data[1][0]= "Adminn" ; data[1][1]= "admin123" ;
        data[2][0]= "Admi" ; data[2][1]= "admin123" ;

        return data;
    }
}
