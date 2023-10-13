package com.nimi.ui_automation.testcases;

import com.nimi.ui_automation.main.RandomData.RandomStringGenerator;
import com.nimi.ui_automation.main.base.TestBase;
import com.nimi.ui_automation.main.commonfunctions.AdminRegisterFunction;
import com.nimi.ui_automation.main.database.DatabaseConnection;
import com.nimi.ui_automation.main.pages.NKVerifyAccountPage;
import com.nimi.ui_automation.main.utility.Waits;
import com.nimi.ui_automation.main.commonfunctions.CompanyRegisterFunction;
import com.nimi.ui_automation.main.pages.NKAdminLoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;

public class NKVerifyAccountPageTest extends TestBase {
    NKVerifyAccountPage nkVerifyAccountPage;
    NKAdminLoginPage nkAdminLoginPage;
    RandomStringGenerator randomStringGenerator;
    AdminRegisterFunction adminRegisterFunction;
    CompanyRegisterFunction companyRegisterFunction;
    DatabaseConnection databaseConnection;
    String newEmail;

    public NKVerifyAccountPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initializationWithRegister();
        nkVerifyAccountPage = new NKVerifyAccountPage(driver);
        nkAdminLoginPage = new NKAdminLoginPage(driver);
        adminRegisterFunction = new AdminRegisterFunction();
        randomStringGenerator = new RandomStringGenerator();
        companyRegisterFunction = new CompanyRegisterFunction();
        databaseConnection = new DatabaseConnection();

        newEmail = randomStringGenerator.randomString+"@gmail.com";
        adminRegisterFunction.adminRegisterFunction(newEmail);
        companyRegisterFunction.companyRegisterFunction();    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 0)
    public void verifyAdminAccount() {
        //Retrieve otp from database
        try (Connection connection = databaseConnection.getConnection(prop.getProperty("host"),prop.getProperty("port"),prop.getProperty("database_name"),prop.getProperty("username"),prop.getProperty("password"));
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM nk_otp WHERE \"otpUserEmail\" = ?")) {

            preparedStatement.setString(1, newEmail);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //Process the retrieved data
                String otp = resultSet.getString("otpCode");
                //Process of enter otp
                if(otp.length()==6) {
                    nkVerifyAccountPage.enterFirstNumberOfOtp(String.valueOf(otp.charAt(0)));
                    nkVerifyAccountPage.enterSecondNumberOfOtp(String.valueOf(otp.charAt(1)));
                    nkVerifyAccountPage.enterThirdNumberOfOtp(String.valueOf(otp.charAt(2)));
                    nkVerifyAccountPage.enterFourthNumberOfOtp(String.valueOf(otp.charAt(3)));
                    nkVerifyAccountPage.enterFifthNumberOfOtp(String.valueOf(otp.charAt(4)));
                    nkVerifyAccountPage.enterSixthNumberOfOtp(String.valueOf(otp.charAt(5)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        nkVerifyAccountPage.clickOnVerifyOtpButton();
        Waits.waitToBeDisplayed(nkAdminLoginPage.txtAdminLogin , Waits.EXPLICIT_WAIT);
        Assert.assertTrue(nkAdminLoginPage.txtAdminLogin.isDisplayed());
    }

}
