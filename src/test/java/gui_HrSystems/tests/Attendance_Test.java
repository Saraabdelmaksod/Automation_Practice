package gui_HrSystems.tests;

import org.testng.annotations.Test;

public class Attendance_Test extends Base_Test{


    @Test
    public void recordAttendanceSuccessfully(){
        LoginPageObj.loginWithValidData("Admin", "admin123");
        MainPageObj.clickOnAttendanceBtn();
       // Attendance_PageObj.enterDate("2023-05-29");
       // Attendance_PageObj.enterTime("11:30 PM");
        Attendance_PageObj.test();
    }

}
