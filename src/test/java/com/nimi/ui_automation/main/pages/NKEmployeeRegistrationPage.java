package com.nimi.ui_automation.main.pages;

import com.nimi.ui_automation.main.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NKEmployeeRegistrationPage extends TestBase {

    public NKEmployeeRegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/p[text()='Employee Registration']")
    public WebElement txtEmployeeRegistration;

    @FindBy(xpath = "//input[@id=':r0:']")
    public WebElement txtFirstName;

    @FindBy(xpath = "//input[@id=':r1:']")
    public WebElement txtLastName;

    @FindBy(xpath = "//input[@id=':r2:']")
    public WebElement txtEmail;

    @FindBy(xpath = "//input[@id=':r3:']")
    public WebElement txtSecondaryEmail;

    @FindBy(xpath = "//input[@id=':r4:']")
    public WebElement txtMobileNumber;

    @FindBy(xpath = "//input[@id=':r5:']")
    public WebElement txtNIC;

    @FindBy(xpath = "//input[@id=':r6:']")
    public WebElement txtDOB;

    @FindBy(xpath = "//button[text()='Next']")
    public WebElement btnNext;

    //Actions
    public void enterFirstName(String firstName){
        txtFirstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        txtLastName.sendKeys(lastName);
    }

    public void enterSecondaryEmail(String secondaryEmail){
        txtSecondaryEmail.sendKeys(secondaryEmail);
    }

    public void enterMobileNumber(String mobileNumber){
        txtMobileNumber.sendKeys(mobileNumber);
    }

    public void enterNIC(String nic){
        txtNIC.sendKeys(nic);
    }

    public void enterDOB(String dob) {
        txtDOB.sendKeys(dob);
    }

    public void clickOnNextButton(){
        btnNext.click();
    }
}
