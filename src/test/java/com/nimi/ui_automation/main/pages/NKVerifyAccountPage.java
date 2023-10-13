package com.nimi.ui_automation.main.pages;

import com.nimi.ui_automation.main.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NKVerifyAccountPage extends TestBase {
    public NKVerifyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/p[text()='Verify Account']")
    public WebElement txtVerifyAccount;
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1q0665x']/u")
    public WebElement otpSentEmail;
    @FindBy(xpath = "//input[@name='d_1']")
    public WebElement firstNumberOfOTP;
    @FindBy(xpath = "//input[@name='d_2']")
    public WebElement secondNumberOfOTP;
    @FindBy(xpath = "//input[@name='d_3']")
    public WebElement thirdNumberOfOTP;
    @FindBy(xpath = "//input[@name='d_4']")
    public WebElement fourthNumberOfOTP;
    @FindBy(xpath = "//input[@name='d_5']")
    public WebElement fifthNumberOfOTP;
    @FindBy(xpath = "//input[@name='d_6']")
    public WebElement sixthNumberOfOTP;
    @FindBy(xpath = "//div/button[text()='Verify OTP']")
    public WebElement btnVerifyOtp;

    public void enterFirstNumberOfOtp(String otp1) {
        firstNumberOfOTP.sendKeys(otp1);
    }
    public void enterSecondNumberOfOtp(String otp2) {
        secondNumberOfOTP.sendKeys(otp2);
    }
    public void enterThirdNumberOfOtp(String otp3) {
        thirdNumberOfOTP.sendKeys(otp3);
    }
    public void enterFourthNumberOfOtp(String otp4) {
        fourthNumberOfOTP.sendKeys(otp4);
    }
    public void enterFifthNumberOfOtp(String otp5) {
        fifthNumberOfOTP.sendKeys(otp5);
    }
    public void enterSixthNumberOfOtp(String otp6) {
        sixthNumberOfOTP.sendKeys(otp6);
    }
    public void clickOnVerifyOtpButton(){
        btnVerifyOtp.click();
    }
}
