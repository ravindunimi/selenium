package com.nimi.ui_automation.main.commonfunctions;

import com.nimi.ui_automation.main.pages.NKEmployeeBulkUploadPage;
import com.nimi.ui_automation.main.utility.Waits;
import com.nimi.ui_automation.main.base.TestBase;
import com.nimi.ui_automation.main.pages.NKAdminLoginPage;
import com.nimi.ui_automation.main.pages.NKEmployeesPage;
import org.testng.Assert;

public class AdminLoginFunction extends TestBase {
    NKAdminLoginPage nkAdminLoginPage;
    NKEmployeeBulkUploadPage nkEmployeeBulkUploadPage;
    NKEmployeesPage nkEmployeesPage;
    public void newAdminLoginFunction(String email , String password) {
        nkAdminLoginPage = new NKAdminLoginPage(driver);
        nkEmployeeBulkUploadPage = new NKEmployeeBulkUploadPage(driver);
        nkEmployeesPage = new NKEmployeesPage(driver);

        nkAdminLoginPage.enterEmail(email);
        nkAdminLoginPage.enterPassword(password);
        nkAdminLoginPage.clickOnLoginButton();
        Waits.waitToBeDisplayed(nkEmployeeBulkUploadPage.txtEmployeeBulkUpload , Waits.EXPLICIT_WAIT);
        Assert.assertTrue(nkEmployeeBulkUploadPage.txtEmployeeBulkUpload.isDisplayed());
    }

    public void adminLoginFunction(String email , String password) {
        nkAdminLoginPage = new NKAdminLoginPage(driver);
        nkEmployeesPage = new NKEmployeesPage(driver);

        nkAdminLoginPage.enterEmail(email);
        nkAdminLoginPage.enterPassword(password);
        nkAdminLoginPage.clickOnLoginButton();
        Waits.waitToBeDisplayed(nkEmployeesPage.employeesPageHeading , Waits.EXPLICIT_WAIT);
        Assert.assertTrue(nkEmployeesPage.employeesPageHeading.isDisplayed());
    }
}
