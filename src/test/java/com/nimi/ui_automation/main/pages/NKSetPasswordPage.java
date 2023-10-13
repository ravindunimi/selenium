package com.nimi.ui_automation.main.pages;

import com.nimi.ui_automation.main.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NKSetPasswordPage extends TestBase {
    public NKSetPasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/p[text()='Set Password']")
    public WebElement txtSetPassword;

    @FindBy(xpath = "//input[@id=':r0:']")
    public WebElement txtPassword;

    @FindBy(xpath = "//input[@id=':r1:']")
    public WebElement txtPasswordConfirm;

    @FindBy(xpath = "//button[text()='Set Password']")
    public WebElement btnSetPassword;

    //Actions
    public void enterPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void enterPasswordConfirm(String passwordConfirm){
        txtPasswordConfirm.sendKeys(passwordConfirm);
    }

    public void clickOnSetPasswordButton(){
        btnSetPassword.click();
    }

}
