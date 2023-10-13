package com.nimi.ui_automation.main.pages;

import com.nimi.ui_automation.main.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NKLeftToolbar extends TestBase {
    public NKLeftToolbar(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[text()='Payroll']")
    public WebElement btnPayroll;

    @FindBy(xpath = "//p[text()='Employees']")
    public WebElement btnEmployees;

    @FindBy(xpath = "//p[text()='Admins']")
    public WebElement btnAdmins;

    @FindBy(xpath = "//p[text()='Profile']")
    public WebElement btnProfile;

    //Actions
    public void clickOnPayrollButton(){
        btnPayroll.click();
    }

    public void clickOnEmployeesButton(){
        btnEmployees.click();
    }

    public void clickOnAdminsButton(){
        btnAdmins.click();
    }

    public void clickOnProfileButton(){
        btnProfile.click();
    }
}
