package com.nimi.ui_automation.main.commonfunctions;

import com.nimi.ui_automation.main.pages.NKAdminRegistrationPage;
import com.nimi.ui_automation.main.pages.NKCompanyRegistrationPage;
import com.nimi.ui_automation.main.utility.TestDataFilePaths;
import com.nimi.ui_automation.main.utility.Waits;
import com.nimi.ui_automation.main.base.TestBase;
import org.testng.Assert;

public class AdminRegisterFunction extends TestBase {
    NKAdminRegistrationPage nkAdminRegistrationPage;
    NKCompanyRegistrationPage nkCompanyRegistrationPage;
    TestDataFilePaths testDataFilePaths;

    public void adminRegisterFunction(String email) throws InterruptedException {
        nkAdminRegistrationPage = new NKAdminRegistrationPage(driver);
        nkCompanyRegistrationPage = new NKCompanyRegistrationPage(driver);
        testDataFilePaths = new TestDataFilePaths();

        nkAdminRegistrationPage.enterName(testDataFilePaths.prop1.getProperty("name"));
        nkAdminRegistrationPage.enterEmail(email);
        nkAdminRegistrationPage.enterMobileNumber(testDataFilePaths.prop1.getProperty("mobileNumber"));
        nkAdminRegistrationPage.enterPassword(testDataFilePaths.prop1.getProperty("password"));
        nkAdminRegistrationPage.enterPasswordConfirm(testDataFilePaths.prop1.getProperty("passwordConfirm"));
        nkAdminRegistrationPage.clickOnAgreeCheckbox();
        nkAdminRegistrationPage.clickOnNextButton();
        Waits.waitToBeDisplayed(nkCompanyRegistrationPage.txtAddCompany , Waits.EXPLICIT_WAIT);
        Assert.assertTrue(nkCompanyRegistrationPage.txtAddCompany.isDisplayed());
    }
}
