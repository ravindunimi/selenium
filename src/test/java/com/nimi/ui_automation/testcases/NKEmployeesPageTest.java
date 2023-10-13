package com.nimi.ui_automation.testcases;

import com.nimi.ui_automation.main.RandomData.RandomStringGenerator;
import com.nimi.ui_automation.main.commonfunctions.AdminLoginFunction;
import com.nimi.ui_automation.main.utility.TestDataFilePaths;
import com.nimi.ui_automation.main.RandomData.RandomNumberGenerator;
import com.nimi.ui_automation.main.base.TestBase;
import com.nimi.ui_automation.main.pages.NKEmployeesPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NKEmployeesPageTest extends TestBase {
    NKEmployeesPage nkEmployeesPage;
    RandomStringGenerator randomStringGenerator;
    RandomNumberGenerator randomNumberGenerator;
    AdminLoginFunction adminLoginFunction;
    TestDataFilePaths testDataFilePaths;
    String newEmail;

    public NKEmployeesPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initializationWithLogin();
        nkEmployeesPage = new NKEmployeesPage(driver);
        randomStringGenerator = new RandomStringGenerator();
        randomNumberGenerator = new RandomNumberGenerator();
        adminLoginFunction = new AdminLoginFunction();
        testDataFilePaths = new TestDataFilePaths();

        newEmail = randomStringGenerator.randomString+"@gmail.com";
        adminLoginFunction.adminLoginFunction(testDataFilePaths.prop3.getProperty("email") , testDataFilePaths.prop3.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 0)
    public void verifyInviteEmployee() throws InterruptedException {
        nkEmployeesPage.clickOnInviteEmployeeButton();
        Assert.assertTrue(nkEmployeesPage.inviteEmployeeViewHeading.isDisplayed());
        nkEmployeesPage.enterEmployeeID(String.valueOf(randomNumberGenerator.randomNumber));
        nkEmployeesPage.enterEmail(newEmail);
        nkEmployeesPage.enterDesignation(testDataFilePaths.prop4.getProperty("designation"));
        nkEmployeesPage.selectDefaultCurrency();
        nkEmployeesPage.enterSalary(testDataFilePaths.prop4.getProperty("salary"));
        Assert.assertTrue(nkEmployeesPage.btnPlus.isEnabled());
        nkEmployeesPage.clickOnPlusButton();
        Assert.assertTrue(nkEmployeesPage.btnInvite.isEnabled());
        nkEmployeesPage.clickOnInviteButton();
        Assert.assertTrue(nkEmployeesPage.employeeInviteSuccessMsg.isDisplayed());
    }

    @Test(priority = 1)
    public void verifyInvitedEmployeesDisplayUnderInvitedTab() throws InterruptedException {
        nkEmployeesPage.clickOnInviteEmployeeButton();
        Assert.assertTrue(nkEmployeesPage.inviteEmployeeViewHeading.isDisplayed());
        nkEmployeesPage.enterEmployeeID(String.valueOf(randomNumberGenerator.randomNumber));
        nkEmployeesPage.enterEmail(newEmail);
        nkEmployeesPage.enterDesignation(testDataFilePaths.prop4.getProperty("designation"));
        nkEmployeesPage.selectDefaultCurrency();
        nkEmployeesPage.enterSalary(testDataFilePaths.prop4.getProperty("salary"));
        Assert.assertTrue(nkEmployeesPage.btnPlus.isEnabled());
        nkEmployeesPage.clickOnPlusButton();
        Assert.assertTrue(nkEmployeesPage.btnInvite.isEnabled());
        nkEmployeesPage.clickOnInviteButton();
        Assert.assertTrue(nkEmployeesPage.employeeInviteSuccessMsg.isDisplayed());
        nkEmployeesPage.clickOnInvitedTab();
        nkEmployeesPage.checkInvitedEmployeeInInvitedTab(newEmail);
    }
}
