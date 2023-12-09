package gui.tests_HR;

import gui_HrSystem.pages.Attendance_Page;
import gui_HrSystem.pages.LoginPage;
import gui_HrSystem.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base_Test {
    public WebDriver driver;
    public static LoginPage LoginPageObj;

    public static MainPage MainPageObj;
    public static Attendance_Page Attendance_PageObj;


    @BeforeClass
    public void openHrSystem(){
        driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        LoginPageObj=new LoginPage(driver);
        MainPageObj=new MainPage(driver);
        Attendance_PageObj=new Attendance_Page(driver);


    }




    @AfterClass
    public void quitDriver(){

       driver.quit();
    }
}
