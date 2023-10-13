package com.nimi.ui_automation.main.pages;

import com.nimi.ui_automation.main.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NKEmployeeRegistrationSecondPage extends TestBase {

    public NKEmployeeRegistrationSecondPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/p[text()='Employee Registration']")
    public WebElement txtEmployeeRegistration;

    @FindBy(xpath = "//input[@id=':r0:']")
    public WebElement txtAddressLine01;

    @FindBy(xpath = "//input[@id=':r1:']")
    public WebElement txtAddressLine02;

    @FindBy(xpath = "//input[@id=':r7:']")
    public WebElement txtCity;

    @FindBy(xpath = "//input[@id=':r2:']")
    public WebElement txtStateProvinceRegion;

    @FindBy(xpath = "//input[@id=':r3:']")
    public WebElement txtZipPostalCode;

    @FindBy(xpath = "//input[@id=':r8:']")
    public WebElement txtCountry;

    @FindBy(xpath = "//input[@class='PrivateSwitchBase-input css-1m9pwf3' and @type='checkbox']")
    public WebElement checkboxAgree;

    @FindBy(xpath = "//button[text()='Next']")
    public WebElement btnNext;

    //Actions
    public void enterAddressLine01(String addressLine01){
        txtAddressLine01.sendKeys(addressLine01);
    }

    public void enterAddressLine02(String addressLine02){
        txtAddressLine02.sendKeys(addressLine02);
    }

    public void enterCity(String city){
        txtCity.sendKeys(city);
    }

    public void enterStateProvinceRegion(String stateProvinceRegion){
        txtStateProvinceRegion.sendKeys(stateProvinceRegion);
    }

    public void enterZipPostalCode(String zipPostalCode){
        txtZipPostalCode.sendKeys(zipPostalCode);
    }

    public void enterCountry(String country){
        txtCountry.sendKeys(country);
    }

    public void clickOnAgreeCheckbox(){
        checkboxAgree.click();
    }

    public void clickOnNextButton(){
        btnNext.click();
    }
}
