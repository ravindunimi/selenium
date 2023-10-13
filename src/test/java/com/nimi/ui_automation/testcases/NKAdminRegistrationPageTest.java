package com.nimi.ui_automation.testcases;

import com.nimi.ui_automation.main.base.TestBase;
import com.nimi.ui_automation.main.pages.NKAdminRegistrationPage;
import com.nimi.ui_automation.main.pages.NKCompanyRegistrationPage;
import com.nimi.ui_automation.main.utility.TestDataFilePaths;
import com.nimi.ui_automation.main.utility.Waits;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NKAdminRegistrationPageTest extends TestBase {

    NKAdminRegistrationPage nkAdminRegistrationPage;
    NKCompanyRegistrationPage nkCompanyRegistrationPage;
    TestDataFilePaths testDataFilePaths;

    public NKAdminRegistrationPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp(){
        initializationWithRegister();
        nkAdminRegistrationPage = new NKAdminRegistrationPage(driver);
        nkCompanyRegistrationPage = new NKCompanyRegistrationPage(driver);
        testDataFilePaths = new TestDataFilePaths();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test (priority = 0)
    public void adminRegisterWithValidCredentials() throws InterruptedException {
        nkAdminRegistrationPage.enterName(testDataFilePaths.prop1.getProperty("name"));
        nkAdminRegistrationPage.enterEmail(testDataFilePaths.prop1.getProperty("email"));
        nkAdminRegistrationPage.enterMobileNumber(testDataFilePaths.prop1.getProperty("mobileNumber"));
        nkAdminRegistrationPage.enterPassword(testDataFilePaths.prop1.getProperty("password"));
        nkAdminRegistrationPage.enterPasswordConfirm(testDataFilePaths.prop1.getProperty("passwordConfirm"));
        nkAdminRegistrationPage.clickOnAgreeCheckbox();
        nkAdminRegistrationPage.clickOnNextButton();
        Waits.waitToBeDisplayed(nkCompanyRegistrationPage.txtAddCompany , Waits.EXPLICIT_WAIT);
        Assert.assertTrue(nkCompanyRegistrationPage.txtAddCompany.isDisplayed());
    }

}
