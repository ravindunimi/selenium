package com.nimi.ui_automation.main.pages;

import com.nimi.ui_automation.main.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NKAdminRegistrationPage extends TestBase {
    public NKAdminRegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id=':r0:']")
    public WebElement txtName;

    @FindBy(xpath = "//input[@id=':r1:']")
    public WebElement txtEmail;

    @FindBy(xpath = "//input[@id=':r2:']")
    public WebElement txtMobileNumber;

    @FindBy(xpath = "//input[@id=':r3:']")
    public WebElement txtPassword;

    @FindBy(xpath = "//input[@id=':r4:']")
    public WebElement txtPasswordConfirm;

    @FindBy(xpath = "//input[@class='PrivateSwitchBase-input css-1m9pwf3' and @type='checkbox']")
    public WebElement checkboxAgree;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1vc28kw']")
    public WebElement btnNext;

    //Actions
    public void enterName(String name){
        txtName.sendKeys(name);
    }

    public void enterEmail(String email) throws InterruptedException {
        txtEmail.sendKeys(email);
        Thread.sleep(1000);
        txtEmail.sendKeys(Keys.BACK_SPACE);
        txtEmail.sendKeys("m");
    }

    public void enterMobileNumber(String mobileNumber){
        txtMobileNumber.sendKeys(mobileNumber);
    }

    public void enterPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void enterPasswordConfirm(String passwordConfirm){
        txtPasswordConfirm.sendKeys(passwordConfirm);
    }

    public void clickOnAgreeCheckbox(){
        checkboxAgree.click();
    }

    public void clickOnNextButton(){
        btnNext.click();
    }
}
