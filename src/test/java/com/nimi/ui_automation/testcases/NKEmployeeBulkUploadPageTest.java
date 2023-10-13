package com.nimi.ui_automation.testcases;

import com.nimi.ui_automation.main.RandomData.RandomStringGenerator;
import com.nimi.ui_automation.main.commonfunctions.AdminLoginFunction;
import com.nimi.ui_automation.main.pages.NKEmployeeBulkUploadPage;
import com.nimi.ui_automation.main.base.TestBase;
import com.nimi.ui_automation.main.commonfunctions.AdminRegisterFunction;
import com.nimi.ui_automation.main.commonfunctions.CompanyRegisterFunction;
import com.nimi.ui_automation.main.commonfunctions.VerifyAccountFunction;
import com.nimi.ui_automation.main.utility.TestDataFilePaths;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NKEmployeeBulkUploadPageTest extends TestBase {
    NKEmployeeBulkUploadPage nkEmployeeBulkUploadPage;
    RandomStringGenerator randomStringGenerator;
    AdminRegisterFunction adminRegisterFunction;
    CompanyRegisterFunction companyRegisterFunction;
    VerifyAccountFunction verifyAccountFunction;
    AdminLoginFunction adminLoginFunction;
    TestDataFilePaths testDataFilePaths;
    String newEmail;

    public NKEmployeeBulkUploadPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initializationWithRegister();
        nkEmployeeBulkUploadPage = new NKEmployeeBulkUploadPage(driver);
        adminRegisterFunction = new AdminRegisterFunction();
        randomStringGenerator = new RandomStringGenerator();
        companyRegisterFunction = new CompanyRegisterFunction();
        verifyAccountFunction = new VerifyAccountFunction();
        adminLoginFunction = new AdminLoginFunction();
        testDataFilePaths = new TestDataFilePaths();

        newEmail = randomStringGenerator.randomString+"@gmail.com";
        adminRegisterFunction.adminRegisterFunction(newEmail);
        companyRegisterFunction.companyRegisterFunction();
        verifyAccountFunction.verifyAccountFunction(newEmail);
        adminLoginFunction.newAdminLoginFunction(newEmail , testDataFilePaths.prop1.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 0)
    public void verifyEmployeeBulkUpload() {
        nkEmployeeBulkUploadPage.uploadCSVFile();
        Assert.assertTrue(nkEmployeeBulkUploadPage.uploadedFile.isDisplayed());
        nkEmployeeBulkUploadPage.clickOnUploadCSVButton();
        //need to refactor this code piece
    }
}
