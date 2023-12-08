package gui.tests_HR;

import org.testng.annotations.Test;
@Test(groups = "Regression")

public class Groups_Test {

    @Test
    public void testCase1(){
        System.out.println("test case one printed successfully ");
    }
    @Test(groups ={"Smoke", "App", "Test"} )
    public void testCase2(){
        System.out.println("test case two printed successfully ");
    }
    @Test(groups ={"App", "Test"} )
    public void testCase3(){
        System.out.println("test case third printed successfully ");

    }
    @Test(groups = "Smoke")
    public void testCase4(){
        System.out.println("test case fourth printed successfully ");

    }
}
