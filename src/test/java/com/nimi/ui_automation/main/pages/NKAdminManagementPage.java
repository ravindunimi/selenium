package com.nimi.ui_automation.main.pages;

import com.nimi.ui_automation.main.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NKAdminManagementPage extends TestBase {

    public NKAdminManagementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/p[text()='Admin Management']")
    public WebElement txtAdminManagement;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement txtName;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement txtEmail;

    @FindBy(xpath = "//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb']")
    public WebElement dropdownAdminType;

    @FindBy(xpath = "//button[text()='Invite an admin']")
    public WebElement btnInviteAdmin;

    @FindBy(xpath = "//p[text()='Email sent Successfully']")
    public WebElement txtEmailSentSuccessfully;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement btnOK;

    @FindBy(xpath = "((//tr[last()])[2]/td)[2]")
    public WebElement finallyAddedAdminEmail;

//    @FindBy(xpath = "//tr/td[contains(text(),'.com')]")
    public List<WebElement> addedAdminEmail = driver.findElements(By.xpath("//tr/td[contains(text(),'.com')]"));

    //Actions
    public void enterName(String name) {
        txtName.sendKeys(name);
    }

    public void enterEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void selectAdminTypeAsAdmin() throws InterruptedException {
        dropdownAdminType.click();
        WebElement selectIndustry = driver.findElement(By.xpath("//ul/li[text()='Admin']"));
        selectIndustry.click();
        Thread.sleep(2000);
    }

    public void selectAdminTypeAsSuperAdmin() throws InterruptedException {
        dropdownAdminType.click();
        WebElement selectIndustry = driver.findElement(By.xpath("//ul/li[text()='Master admin']"));
        selectIndustry.click();
        Thread.sleep(2000);
    }

    public void clickOnInviteAdminButton(){
        btnInviteAdmin.click();
    }

    public void clickOnOKButton(){
        btnOK.click();
    }
}
