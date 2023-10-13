package com.nimi.ui_automation.testcases;

import com.nimi.ui_automation.main.RandomData.RandomStringGenerator;
import com.nimi.ui_automation.main.base.TestBase;
import com.nimi.ui_automation.main.commonfunctions.AdminRegisterFunction;
import com.nimi.ui_automation.main.commonfunctions.CompanyRegisterFunction;
import com.nimi.ui_automation.main.commonfunctions.VerifyAccountFunction;
import com.nimi.ui_automation.main.pages.NKAdminLoginPage;
import com.nimi.ui_automation.main.pages.NKEmployeeBulkUploadPage;
import com.nimi.ui_automation.main.pages.NKVerifyAccountPage;
import com.nimi.ui_automation.main.utility.TestDataFilePaths;
import com.nimi.ui_automation.main.utility.Waits;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NKAdminLoginPageTest extends TestBase {
    NKVerifyAccountPage nkVerifyAccountPage;
    NKAdminLoginPage nkAdminLoginPage;
    NKEmployeeBulkUploadPage nkEmployeeBulkUploadPage;
    RandomStringGenerator randomStringGenerator;
    AdminRegisterFunction adminRegisterFunction;
    CompanyRegisterFunction companyRegisterFunction;
    VerifyAccountFunction verifyAccountFunction;
    TestDataFilePaths testDataFilePaths;
    String newEmail;

    public NKAdminLoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initializationWithRegister();
        nkVerifyAccountPage = new NKVerifyAccountPage(driver);
        nkAdminLoginPage = new NKAdminLoginPage(driver);
        nkEmployeeBulkUploadPage = new NKEmployeeBulkUploadPage(driver);
        adminRegisterFunction = new AdminRegisterFunction();
        randomStringGenerator = new RandomStringGenerator();
        companyRegisterFunction = new CompanyRegisterFunction();
        verifyAccountFunction = new VerifyAccountFunction();
        testDataFilePaths = new TestDataFilePaths();

        newEmail = randomStringGenerator.randomString+"@gmail.com";
        adminRegisterFunction.adminRegisterFunction(newEmail);
        companyRegisterFunction.companyRegisterFunction();
        verifyAccountFunction.verifyAccountFunction(newEmail);
        Waits.waitToBeDisplayed(nkAdminLoginPage.txtAdminLogin, Waits.EXPLICIT_WAIT);
        Assert.assertTrue(nkAdminLoginPage.txtAdminLogin.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 0)
    public void adminLoginWithValidCredentials() {
        nkAdminLoginPage.enterEmail(newEmail);
        nkAdminLoginPage.enterPassword(testDataFilePaths.prop1.getProperty("password"));
        nkAdminLoginPage.clickOnLoginButton();
        Waits.waitToBeDisplayed(nkEmployeeBulkUploadPage.txtEmployeeBulkUpload , Waits.EXPLICIT_WAIT);
        Assert.assertTrue(nkEmployeeBulkUploadPage.txtEmployeeBulkUpload.isDisplayed());
    }
}
