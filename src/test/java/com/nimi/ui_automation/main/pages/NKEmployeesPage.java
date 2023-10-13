package com.nimi.ui_automation.main.pages;

import com.nimi.ui_automation.main.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NKEmployeesPage extends TestBase {

    public NKEmployeesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='MuiBox-root css-pjeiro']/p[text()='Employees']")
    public WebElement employeesPageHeading;

    @FindBy(xpath = "//button[text()='Invite an Employee']")
    public WebElement btnInviteEmployee;

    @FindBy(xpath = "//div/h2[text()='Invite employee']")
    public WebElement inviteEmployeeViewHeading;

    @FindBy(xpath = "//input[@placeholder='Employee ID']")
    public WebElement txtEmployeeID;

    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement txtEmail;

    @FindBy(xpath = "//input[@placeholder='Designation']")
    public WebElement txtDesignation;

    @FindBy(xpath = "//div[contains(@class,'MuiInputBase')]/div")
    public WebElement dropdownDefaultCurrency;

    @FindBy(xpath = "//input[@placeholder='Salary']")
    public WebElement txtSalary;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk']")
    public WebElement btnPlus;

    @FindBy(xpath = "//button[text()='Invite']")
    public WebElement btnInvite;

    @FindBy(xpath = "//div[text()='Invitations have been sent successfully']")
    public WebElement employeeInviteSuccessMsg;

    @FindBy(xpath = "//div/button[text()='Active']")
    public WebElement activeTab;

    @FindBy(xpath = "//div/button[text()='Inactive']")
    public WebElement inactiveTab;

    @FindBy(xpath = "//div/button[text()='Invited']")
    public WebElement invitedTab;

    //Actions
    public void clickOnInviteEmployeeButton(){
        btnInviteEmployee.click();
    }

    public void enterEmployeeID(String empID){
        txtEmployeeID.sendKeys(empID);
    }

    public void enterEmail(String email){
        txtEmail.sendKeys(email);
    }

    public void enterDesignation(String designation){
        txtDesignation.sendKeys(designation);
    }

    public void selectDefaultCurrency() throws InterruptedException {
        dropdownDefaultCurrency.click();
        WebElement selectDefaultCurrency = driver.findElement(By.xpath("//ul/li[text()='Sri Lankan Rupee']"));
        selectDefaultCurrency.click();
        Thread.sleep(2000);
    }

    public void enterSalary(String salary){
        txtSalary.sendKeys(salary);
    }

    public void clickOnPlusButton(){
        btnPlus.click();
    }

    public void clickOnInviteButton(){
        btnInvite.click();
    }

    public void clickOnInvitedTab(){
        invitedTab.click();
    }

    public void checkInvitedEmployeeInInvitedTab(String email){
        WebElement invitedEmployeeEmail = driver.findElement(By.xpath("//tr/td[text()='"+email+"']"));
        Assert.assertTrue(invitedEmployeeEmail.isDisplayed());
    }
}
