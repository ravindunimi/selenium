package com.nimi.ui_automation.main.pages;

import com.nimi.ui_automation.main.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NKEmployeeRegistrationCompletePage extends TestBase {
    public NKEmployeeRegistrationCompletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/p[text()='Congratulations !']")
    public WebElement txtCongratulations;

    @FindBy(xpath = "(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[1]")
    public WebElement btnPlayStore;

    @FindBy(xpath = "(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[2]")
    public WebElement btnAppStore;

    //Actions
    public void clickOnPlayStoreButton(){
        btnPlayStore.click();
    }

    public void clickOnAppStoreButton(){
        btnAppStore.click();
    }
}
