package com.nimi.ui_automation.main.commonfunctions;

import com.nimi.ui_automation.main.base.TestBase;
import com.nimi.ui_automation.main.database.DatabaseConnection;
import com.nimi.ui_automation.main.pages.NKAdminLoginPage;
import com.nimi.ui_automation.main.pages.NKVerifyAccountPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerifyAccountFunction extends TestBase {
    NKVerifyAccountPage nkVerifyAccountPage;
    NKAdminLoginPage nkAdminLoginPage;
    DatabaseConnection databaseConnection;

    public void verifyAccountFunction(String email) {
        nkVerifyAccountPage = new NKVerifyAccountPage(driver);
        nkAdminLoginPage = new NKAdminLoginPage(driver);
        databaseConnection = new DatabaseConnection();

        //Retrieve otp from database
        try (
                Connection connection = databaseConnection.getConnection(prop.getProperty("host"), prop.getProperty("port"), prop.getProperty("database_name"), prop.getProperty("username"), prop.getProperty("password"));
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM nk_otp WHERE \"otpUserEmail\" = ?")) {

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Process the retrieved data
                String otp = resultSet.getString("otpCode");
                if (otp.length() == 6) {
                    nkVerifyAccountPage.enterFirstNumberOfOtp(String.valueOf(otp.charAt(0)));
                    nkVerifyAccountPage.enterSecondNumberOfOtp(String.valueOf(otp.charAt(1)));
                    nkVerifyAccountPage.enterThirdNumberOfOtp(String.valueOf(otp.charAt(2)));
                    nkVerifyAccountPage.enterFourthNumberOfOtp(String.valueOf(otp.charAt(3)));
                    nkVerifyAccountPage.enterFifthNumberOfOtp(String.valueOf(otp.charAt(4)));
                    nkVerifyAccountPage.enterSixthNumberOfOtp(String.valueOf(otp.charAt(5)));
                }
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        nkVerifyAccountPage.clickOnVerifyOtpButton();
    }
}
