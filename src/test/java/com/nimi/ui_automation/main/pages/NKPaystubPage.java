package com.nimi.ui_automation.main.pages;

import com.nimi.ui_automation.main.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NKPaystubPage extends TestBase {
    public NKPaystubPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='search']")
    public WebElement searchBar;

    @FindBy(xpath = "//div[@id=':r2:']")
    public WebElement dropdownYear;

    @FindBy(xpath = "//div[@id=':r3:']")
    public WebElement dropdownMonth;

    @FindBy(xpath = "//div[@id=':r4:']")
    public WebElement dropdownPayslipType;

    @FindBy(xpath = "//button[text()='Payroll Settings']")
    public WebElement btnPayrollSettings;
}
