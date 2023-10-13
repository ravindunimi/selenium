package com.nimi.ui_automation.main.commonfunctions;

import com.nimi.ui_automation.main.RandomData.RandomNumberGenerator;
import com.nimi.ui_automation.main.base.TestBase;
import com.nimi.ui_automation.main.pages.NKEmployeesPage;
import com.nimi.ui_automation.main.utility.TestDataFilePaths;
import org.testng.Assert;

public class InviteEmployeeFunction extends TestBase {
    NKEmployeesPage nkEmployeesPage;
    RandomNumberGenerator randomNumberGenerator;
    TestDataFilePaths testDataFilePaths;

    public void inviteEmployeeFunction(String email) throws InterruptedException {
        nkEmployeesPage = new NKEmployeesPage(driver);
        randomNumberGenerator = new RandomNumberGenerator();
        testDataFilePaths = new TestDataFilePaths();

        nkEmployeesPage.clickOnInviteEmployeeButton();
        Assert.assertTrue(nkEmployeesPage.inviteEmployeeViewHeading.isDisplayed());
        nkEmployeesPage.enterEmployeeID(String.valueOf(randomNumberGenerator.randomNumber));
        nkEmployeesPage.enterEmail(email);
        nkEmployeesPage.enterDesignation(testDataFilePaths.prop4.getProperty("designation"));
        nkEmployeesPage.selectDefaultCurrency();
        nkEmployeesPage.enterSalary(testDataFilePaths.prop4.getProperty("salary"));
        Assert.assertTrue(nkEmployeesPage.btnPlus.isEnabled());
        nkEmployeesPage.clickOnPlusButton();
        Assert.assertTrue(nkEmployeesPage.btnInvite.isEnabled());
        nkEmployeesPage.clickOnInviteButton();
        Assert.assertTrue(nkEmployeesPage.employeeInviteSuccessMsg.isDisplayed());
    }
}
