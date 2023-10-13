package com.nimi.ui_automation.main.commonfunctions;

import com.nimi.ui_automation.main.RandomData.RandomStringGenerator;
import com.nimi.ui_automation.main.base.TestBase;
import com.nimi.ui_automation.main.pages.NKCompanyRegistrationPage;
import com.nimi.ui_automation.main.pages.NKVerifyAccountPage;
import com.nimi.ui_automation.main.utility.TestDataFilePaths;
import com.nimi.ui_automation.main.utility.Waits;
import org.testng.Assert;

public class CompanyRegisterFunction extends TestBase {
    NKCompanyRegistrationPage nkCompanyRegistrationPage;
    RandomStringGenerator randomStringGenerator;
    NKVerifyAccountPage nkVerifyAccountPage;
    TestDataFilePaths testDataFilePaths;

    public void companyRegisterFunction() throws InterruptedException {
        nkCompanyRegistrationPage = new NKCompanyRegistrationPage(driver);
        testDataFilePaths = new TestDataFilePaths();
        randomStringGenerator = new RandomStringGenerator();
        nkVerifyAccountPage = new NKVerifyAccountPage(driver);

        nkCompanyRegistrationPage.enterCompanyName(randomStringGenerator.randomString);
        nkCompanyRegistrationPage.selectIndustry();
        nkCompanyRegistrationPage.selectDefaultCurrency();
        nkCompanyRegistrationPage.clickOnRegisterButton();
        Waits.waitToBeDisplayed(nkVerifyAccountPage.txtVerifyAccount , Waits.EXPLICIT_WAIT);
        Assert.assertTrue(nkVerifyAccountPage.txtVerifyAccount.isDisplayed());
    }
}
