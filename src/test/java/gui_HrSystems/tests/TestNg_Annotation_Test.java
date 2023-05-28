package gui_HrSystems.tests;

import org.testng.annotations.*;

public class TestNg_Annotation_Test {
    @Test
    public void testCase1() {
        System.out.println("Test Case #1");
    }
    @Test
    public void testCase2() {
        System.out.println("Test Case #2");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod will run Before each Test Case");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod will run After each Test Case");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass will run Before the Test Cases Only Once");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass will run After the Test Cases Only Once");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest will run before the first @Test annotated method");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest will run will be executed when all @Test annotated methods complete the execution of those classes");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuit will run Before All other annotations Only Once");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuit will run after Running the Test is done Only Once");
    }

}
