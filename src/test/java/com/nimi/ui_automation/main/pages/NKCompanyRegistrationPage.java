package com.nimi.ui_automation.main.pages;

import com.nimi.ui_automation.main.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NKCompanyRegistrationPage extends TestBase {
    public NKCompanyRegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/p[text()='Add your details to get your company registered']")
    public WebElement txtAddCompany;

    @FindBy(xpath = "//input[@id=':r5:']")
    public WebElement txtCompanyName;

    @FindBy(xpath = "//div[@id=':r6:']")
    public WebElement dropdownIndustry;

    @FindBy(xpath = "//div[@id=':r7:']")
    public WebElement dropdownDefaultCurrency;

    @FindBy(xpath = "//button[text()='Register']")
    public WebElement btnRegister;

    @FindBy(xpath = "//button[text()='Go back']")
    public WebElement btnGoBack;

    //Actions
    public void enterCompanyName(String companyName){
        txtCompanyName.sendKeys(companyName);
    }

    public void selectIndustry() throws InterruptedException {
        dropdownIndustry.click();
        WebElement selectIndustry = driver.findElement(By.xpath("//ul/li[text()='Education']"));
        selectIndustry.click();
        Thread.sleep(2000);
    }

    public void selectDefaultCurrency() throws InterruptedException {
        dropdownDefaultCurrency.click();
        WebElement selectDefaultCurrency = driver.findElement(By.xpath("//ul/li[text()='Sri Lankan Rupee']"));
        selectDefaultCurrency.click();
        Thread.sleep(2000);
    }

    public void clickOnRegisterButton(){
        btnRegister.click();
    }
}
