package com.nimi.ui_automation.main.base;

import com.nimi.ui_automation.main.utility.Waits;
import io.restassured.RestAssured;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    protected Log logger = LogFactory.getLog(getClass());

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/test/java/com/nimi/ui_automation/main/config/config.properties");
            prop.load(ip);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initializationWithRegister() {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Waits.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Waits.IMPLICIT_WAIT));

        driver.get(prop.getProperty("register_url"));
    }

    public static void initializationWithLogin() {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Waits.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Waits.IMPLICIT_WAIT));

        driver.get(prop.getProperty("login_url"));
    }

    public static void mailTmInitialization() {
        RestAssured.baseURI = prop.getProperty("mail_tm_url");
    }


}
