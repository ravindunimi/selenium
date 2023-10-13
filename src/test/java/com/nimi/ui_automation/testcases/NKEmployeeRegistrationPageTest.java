package com.nimi.ui_automation.testcases;

import com.nimi.ui_automation.main.pages.*;
import com.nimi.ui_automation.main.RandomData.RandomStringGenerator;
import com.nimi.ui_automation.main.base.TestBase;
import com.nimi.ui_automation.main.commonfunctions.AdminLoginFunction;
import com.nimi.ui_automation.main.commonfunctions.InviteEmployeeFunction;
import com.nimi.ui_automation.main.commonfunctions.VerifyAccountFunction;
import com.nimi.ui_automation.main.pages.*;
import com.nimi.ui_automation.main.utility.TestDataFilePaths;
import com.nimi.ui_automation.main.utility.Waits;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NKEmployeeRegistrationPageTest extends TestBase {
    NKEmployeeRegistrationPage nkEmployeeRegistrationPage;
    NKEmployeeRegistrationSecondPage nkEmployeeRegistrationSecondPage;
    NKSetPasswordPage nkSetPasswordPage;
    NKEmployeeRegistrationCompletePage nkEmployeeRegistrationCompletePage;
    NKVerifyAccountPage nkVerifyAccountPage;
    RandomStringGenerator randomStringGenerator;
    AdminLoginFunction adminLoginFunction;
    InviteEmployeeFunction inviteEmployeeFunction;
    VerifyAccountFunction verifyAccountFunction;
    TestDataFilePaths testDataFilePaths;
    String newEmail;

    public NKEmployeeRegistrationPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initializationWithLogin();
        nkEmployeeRegistrationPage = new NKEmployeeRegistrationPage(driver);
        nkEmployeeRegistrationSecondPage = new NKEmployeeRegistrationSecondPage(driver);
        nkSetPasswordPage = new NKSetPasswordPage(driver);
        nkEmployeeRegistrationCompletePage = new NKEmployeeRegistrationCompletePage(driver);
        nkVerifyAccountPage = new NKVerifyAccountPage(driver);
        randomStringGenerator = new RandomStringGenerator();
        adminLoginFunction = new AdminLoginFunction();
        inviteEmployeeFunction = new InviteEmployeeFunction();
        testDataFilePaths = new TestDataFilePaths();
        verifyAccountFunction = new VerifyAccountFunction();

        newEmail = randomStringGenerator.randomString+"@gmail.com";
        adminLoginFunction.adminLoginFunction(testDataFilePaths.prop3.getProperty("email") , testDataFilePaths.prop3.getProperty("password"));
        inviteEmployeeFunction.inviteEmployeeFunction(newEmail);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 0)
    public void employeeRegisterWithValidCredentialsFirstPage() throws InterruptedException {
        String employeeRegisterUrl = "https://app-qa.nimikash.com/genericRegistration/employee/"+newEmail;
        driver.get(employeeRegisterUrl);
        Assert.assertTrue(nkEmployeeRegistrationPage.txtEmployeeRegistration.isDisplayed());
        nkEmployeeRegistrationPage.enterFirstName(testDataFilePaths.prop5.getProperty("firstName"));
        nkEmployeeRegistrationPage.enterLastName(testDataFilePaths.prop5.getProperty("lastName"));
        Assert.assertEquals(nkEmployeeRegistrationPage.txtEmail.getAttribute("placeholder"),newEmail);
        nkEmployeeRegistrationPage.enterSecondaryEmail(testDataFilePaths.prop5.getProperty("secondaryEmail"));
        nkEmployeeRegistrationPage.enterMobileNumber(testDataFilePaths.prop5.getProperty("mobileNumber"));
        nkEmployeeRegistrationPage.enterNIC(testDataFilePaths.prop5.getProperty("nicNumber"));
        nkEmployeeRegistrationPage.enterDOB(testDataFilePaths.prop5.getProperty("dateOfBirth"));
        Assert.assertTrue(nkEmployeeRegistrationPage.btnNext.isEnabled());
        nkEmployeeRegistrationPage.clickOnNextButton();
        Waits.waitToBeDisplayed(nkEmployeeRegistrationSecondPage.txtEmployeeRegistration , Waits.EXPLICIT_WAIT);
        Assert.assertTrue(nkEmployeeRegistrationSecondPage.txtEmployeeRegistration.isDisplayed());
    }

    @Test(priority = 1)
    public void employeeRegisterWithValidCredentialsSecondPage() throws InterruptedException {
        this.employeeRegisterWithValidCredentialsFirstPage();
        Thread.sleep(2000);
        nkEmployeeRegistrationSecondPage.enterAddressLine01(testDataFilePaths.prop5.getProperty("addressLine01"));
        nkEmployeeRegistrationSecondPage.enterAddressLine02(testDataFilePaths.prop5.getProperty("addressLine02"));
        nkEmployeeRegistrationSecondPage.enterCity(testDataFilePaths.prop5.getProperty("city"));
        nkEmployeeRegistrationSecondPage.enterStateProvinceRegion(testDataFilePaths.prop5.getProperty("stateProvinceRegion"));
        nkEmployeeRegistrationSecondPage.enterZipPostalCode(testDataFilePaths.prop5.getProperty("zipPostalCode"));
        nkEmployeeRegistrationSecondPage.enterCountry(testDataFilePaths.prop5.getProperty("country"));
        nkEmployeeRegistrationSecondPage.clickOnAgreeCheckbox();
        Assert.assertTrue(nkEmployeeRegistrationSecondPage.btnNext.isEnabled());
        nkEmployeeRegistrationSecondPage.clickOnNextButton();
        Waits.waitToBeDisplayed(nkSetPasswordPage.txtSetPassword , Waits.EXPLICIT_WAIT);
        Assert.assertTrue(nkSetPasswordPage.txtSetPassword.isDisplayed());
    }

    @Test(priority = 2)
    public void setPasswordForEmployeeRegistration() throws InterruptedException {
        this.employeeRegisterWithValidCredentialsSecondPage();
        Thread.sleep(2000);
        nkSetPasswordPage.enterPassword(testDataFilePaths.prop5.getProperty("password"));
        nkSetPasswordPage.enterPasswordConfirm(testDataFilePaths.prop5.getProperty("passwordConfirm"));
        nkSetPasswordPage.clickOnSetPasswordButton();
        Waits.waitToBeDisplayed(nkVerifyAccountPage.txtVerifyAccount , Waits.EXPLICIT_WAIT);
        Assert.assertTrue(nkVerifyAccountPage.txtVerifyAccount.isDisplayed());
        verifyAccountFunction.verifyAccountFunction(newEmail);
        Waits.waitToBeDisplayed(nkEmployeeRegistrationCompletePage.txtCongratulations , Waits.EXPLICIT_WAIT);
        Assert.assertTrue(nkEmployeeRegistrationCompletePage.txtCongratulations.isDisplayed());
    }
}