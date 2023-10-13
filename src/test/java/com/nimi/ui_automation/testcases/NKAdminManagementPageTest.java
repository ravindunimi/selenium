package com.nimi.ui_automation.testcases;

import com.nimi.ui_automation.main.RandomData.RandomStringGenerator;
import com.nimi.ui_automation.main.base.TestBase;
import com.nimi.ui_automation.main.commonfunctions.AdminLoginFunction;
import com.nimi.ui_automation.main.pages.NKAdminManagementPage;
import com.nimi.ui_automation.main.pages.NKAdminRegistrationPage;
import com.nimi.ui_automation.main.pages.NKLeftToolbar;
import com.nimi.ui_automation.main.utility.TestDataFilePaths;
import com.nimi.ui_automation.main.utility.Waits;
import com.nimi.ui_automation.main.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NKAdminManagementPageTest extends TestBase {
    NKAdminManagementPage nkAdminManagementPage;
    NKAdminRegistrationPage nkAdminRegistrationPage;
    NKLeftToolbar nkLeftToolbar;
    RandomStringGenerator randomStringGenerator;
    AdminLoginFunction adminLoginFunction;
    TestDataFilePaths testDataFilePaths;
    String newEmail;

    public NKAdminManagementPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initializationWithLogin();
        nkAdminManagementPage = new NKAdminManagementPage(driver);
        nkLeftToolbar = new NKLeftToolbar(driver);
        nkAdminRegistrationPage = new NKAdminRegistrationPage(driver);
        randomStringGenerator = new RandomStringGenerator();
        adminLoginFunction = new AdminLoginFunction();
        testDataFilePaths = new TestDataFilePaths();

        newEmail = randomStringGenerator.randomString+"@gmail.com";
        adminLoginFunction.adminLoginFunction(testDataFilePaths.prop3.getProperty("email") , testDataFilePaths.prop3.getProperty("password"));
        nkLeftToolbar.clickOnAdminsButton();
        Waits.waitToBeDisplayed(nkAdminManagementPage.txtAdminManagement , Waits.EXPLICIT_WAIT);
        Assert.assertTrue(nkAdminManagementPage.txtAdminManagement.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 0)
    public void verifyInviteAdmin() throws InterruptedException {
        nkAdminManagementPage.enterName(testDataFilePaths.prop6.getProperty("nameAdmin"));
        nkAdminManagementPage.enterEmail(newEmail);
        nkAdminManagementPage.selectAdminTypeAsAdmin();
        nkAdminManagementPage.clickOnInviteAdminButton();
        Waits.waitToBeDisplayed(nkAdminManagementPage.txtEmailSentSuccessfully , Waits.EXPLICIT_WAIT);
        Assert.assertTrue(nkAdminManagementPage.txtEmailSentSuccessfully.isDisplayed());
        nkAdminManagementPage.clickOnOKButton();

        for(int i=0;i<nkAdminManagementPage.addedAdminEmail.size();i++){
            if(nkAdminManagementPage.addedAdminEmail.get(i).getText().equals(newEmail)){
                Assert.assertEquals(nkAdminManagementPage.addedAdminEmail.get(i).getText(),newEmail);
            }
        }
    }

    @Test(priority = 1)
    public void verifyInviteMasterAdmin() throws InterruptedException {
        nkAdminManagementPage.enterName(testDataFilePaths.prop6.getProperty("nameSuperAdmin"));
        nkAdminManagementPage.enterEmail(newEmail);
        nkAdminManagementPage.selectAdminTypeAsSuperAdmin();
        nkAdminManagementPage.clickOnInviteAdminButton();
        Waits.waitToBeDisplayed(nkAdminManagementPage.txtEmailSentSuccessfully , Waits.EXPLICIT_WAIT);
        Assert.assertTrue(nkAdminManagementPage.txtEmailSentSuccessfully.isDisplayed());
        nkAdminManagementPage.clickOnOKButton();

        for(int i=0;i<nkAdminManagementPage.addedAdminEmail.size();i++){
            if(nkAdminManagementPage.addedAdminEmail.get(i).getText().equals(newEmail)){
                Assert.assertEquals(nkAdminManagementPage.addedAdminEmail.get(i).getText(),newEmail);
            }
        }
    }

    @Test(priority = 2)
    public void verifyAdminRegisterViaInviteLink() throws InterruptedException {
        nkAdminManagementPage.enterName(testDataFilePaths.prop6.getProperty("nameAdmin"));
        nkAdminManagementPage.enterEmail(newEmail);
        nkAdminManagementPage.selectAdminTypeAsAdmin();
        nkAdminManagementPage.clickOnInviteAdminButton();
        Waits.waitToBeDisplayed(nkAdminManagementPage.txtEmailSentSuccessfully , Waits.EXPLICIT_WAIT);
        Assert.assertTrue(nkAdminManagementPage.txtEmailSentSuccessfully.isDisplayed());
        nkAdminManagementPage.clickOnOKButton();

        for(int i=0;i<nkAdminManagementPage.addedAdminEmail.size();i++){
            if(nkAdminManagementPage.addedAdminEmail.get(i).getText().equals(newEmail)){
                Assert.assertEquals(nkAdminManagementPage.addedAdminEmail.get(i).getText(),newEmail);
            }
        }
        driver.get("https://app-qa.nimikash.com/genericRegistration/admin/"+newEmail);
        Assert.assertEquals(nkAdminRegistrationPage.txtName.getText(),testDataFilePaths.prop6.getProperty("nameAdmin"));
        Assert.assertEquals(nkAdminRegistrationPage.txtEmail.getText(),newEmail);
        nkAdminRegistrationPage.enterMobileNumber(testDataFilePaths.prop1.getProperty("mobileNumber"));
        nkAdminRegistrationPage.enterPassword(testDataFilePaths.prop1.getProperty("password"));
        nkAdminRegistrationPage.enterPasswordConfirm(testDataFilePaths.prop1.getProperty("passwordConfirm"));
        nkAdminRegistrationPage.clickOnAgreeCheckbox();
        nkAdminRegistrationPage.clickOnNextButton();
    }

    @Test(priority = 3)
    public void verifyMasterAdminRegisterViaInviteLink() throws InterruptedException {
        nkAdminManagementPage.enterName(testDataFilePaths.prop6.getProperty("nameSuperAdmin"));
        nkAdminManagementPage.enterEmail(newEmail);
        nkAdminManagementPage.selectAdminTypeAsSuperAdmin();
        nkAdminManagementPage.clickOnInviteAdminButton();
        Waits.waitToBeDisplayed(nkAdminManagementPage.txtEmailSentSuccessfully , Waits.EXPLICIT_WAIT);
        Assert.assertTrue(nkAdminManagementPage.txtEmailSentSuccessfully.isDisplayed());
        nkAdminManagementPage.clickOnOKButton();

        for(int i=0;i<nkAdminManagementPage.addedAdminEmail.size();i++){
            if(nkAdminManagementPage.addedAdminEmail.get(i).getText().equals(newEmail)){
                Assert.assertEquals(nkAdminManagementPage.addedAdminEmail.get(i).getText(),newEmail);
            }
        }
        driver.get("https://app-qa.nimikash.com/genericRegistration/admin/"+newEmail);
        Thread.sleep(2000);
        Assert.assertEquals(nkAdminRegistrationPage.txtName.getText(),testDataFilePaths.prop6.getProperty("nameSuperAdmin"));
        Assert.assertEquals(nkAdminRegistrationPage.txtEmail.getText(),newEmail);
        nkAdminRegistrationPage.enterMobileNumber(testDataFilePaths.prop1.getProperty("mobileNumber"));
        nkAdminRegistrationPage.enterPassword(testDataFilePaths.prop1.getProperty("password"));
        nkAdminRegistrationPage.enterPasswordConfirm(testDataFilePaths.prop1.getProperty("passwordConfirm"));
        nkAdminRegistrationPage.clickOnAgreeCheckbox();
        nkAdminRegistrationPage.clickOnNextButton();
    }

}
