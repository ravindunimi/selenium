package com.nimi.ui_automation.main.pages;

import com.nimi.ui_automation.main.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NKEmployeeBulkUploadPage extends TestBase {
    public NKEmployeeBulkUploadPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/p[text()='Employee Bulk Upload']")
    public WebElement txtEmployeeBulkUpload;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement linkBrowse;

    @FindBy(xpath = "//div/button[text()='Upload CSV']")
    public WebElement btnUploadCSV;

    @FindBy(xpath = "//span[@class='MuiChip-label MuiChip-labelMedium css-9iedg7']")
    public WebElement uploadedFile;

    //Actions
    public void uploadCSVFile() {
        linkBrowse.sendKeys("C:\\Users\\Oshani Perera\\Documents\\NimiKash_UI_Automation\\src\\test\\java\\com\\nimi\\ui_automation\\main\\testdata\\TestFile.csv");
    }

    public void clickOnUploadCSVButton(){
        btnUploadCSV.click();
    }
}
