package com.nimi.ui_automation.main.pages;

import com.nimi.ui_automation.main.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NKAdminLoginPage extends TestBase {
    public NKAdminLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/p[text()='Admin Login']")
    public WebElement txtAdminLogin;

    @FindBy(xpath = "//input[@id=':r0:']")
    public WebElement txtEmail;

    @FindBy(xpath = "//input[@id=':r1:']")
    public WebElement txtPassword;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement btnLogin;

    //Actions
    public void enterEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void enterPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void clickOnLoginButton(){
        btnLogin.click();
    }

}
