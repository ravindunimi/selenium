package com.nimi.ui_automation.testcases;

import com.nimi.ui_automation.main.RandomData.RandomStringGenerator;
import com.nimi.ui_automation.main.commonfunctions.AdminRegisterFunction;
import com.nimi.ui_automation.main.pages.NKCompanyRegistrationPage;
import com.nimi.ui_automation.main.utility.TestDataFilePaths;
import com.nimi.ui_automation.main.utility.Waits;
import com.nimi.ui_automation.main.base.TestBase;
import com.nimi.ui_automation.main.commonfunctions.MailTMFunctions;
import com.nimi.ui_automation.main.pages.NKVerifyAccountPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NKCompanyRegistrationPageTest extends TestBase {
    NKCompanyRegistrationPage nkCompanyRegistrationPage;
    TestDataFilePaths testDataFilePaths;
    AdminRegisterFunction adminRegisterFunction;
    RandomStringGenerator randomStringGenerator;
    NKVerifyAccountPage nkVerifyAccountPage;
    MailTMFunctions mailTMFunctions;

    public NKCompanyRegistrationPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initializationWithRegister();
        nkCompanyRegistrationPage = new NKCompanyRegistrationPage(driver);
        testDataFilePaths = new TestDataFilePaths();
        adminRegisterFunction = new AdminRegisterFunction();
        randomStringGenerator = new RandomStringGenerator();
        nkVerifyAccountPage = new NKVerifyAccountPage(driver);
        mailTMFunctions = new MailTMFunctions();
        String domain = mailTMFunctions.retrieveMailTmDomain();
        String newEmail = randomStringGenerator.randomString+"@"+domain;
        adminRegisterFunction.adminRegisterFunction(newEmail);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 0)
    public void companyRegisterWithValidData() throws InterruptedException {
        nkCompanyRegistrationPage.enterCompanyName(randomStringGenerator.randomString);
        nkCompanyRegistrationPage.selectIndustry();
        nkCompanyRegistrationPage.selectDefaultCurrency();
        nkCompanyRegistrationPage.clickOnRegisterButton();
        Waits.waitToBeDisplayed(nkVerifyAccountPage.txtVerifyAccount , Waits.EXPLICIT_WAIT);
        Assert.assertTrue(nkVerifyAccountPage.txtVerifyAccount.isDisplayed());
    }
}
