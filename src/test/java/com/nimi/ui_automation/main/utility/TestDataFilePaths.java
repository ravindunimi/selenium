package com.nimi.ui_automation.main.utility;

import com.nimi.ui_automation.main.base.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestDataFilePaths extends TestBase {
    public static Properties prop1,prop2,prop3,prop4,prop5,prop6;
    public TestDataFilePaths() {
        try {
            prop1 = new Properties();
            FileInputStream ip1 = new FileInputStream("src//test//java//com//nimi//ui_automation//main//testdata//adminRegister.properties");
            prop1.load(ip1);

            prop2 = new Properties();
            FileInputStream ip2 = new FileInputStream("src//test//java//com//nimi//ui_automation//main//testdata//adminRegister.properties");
            prop2.load(ip2);

            prop3 = new Properties();
            FileInputStream ip3 = new FileInputStream("src//test//java//com//nimi//ui_automation//main//testdata//adminLogin.properties");
            prop3.load(ip3);

            prop4 = new Properties();
            FileInputStream ip4 = new FileInputStream("src//test//java//com//nimi//ui_automation//main//testdata//inviteEmployees.properties");
            prop4.load(ip4);

            prop5 = new Properties();
            FileInputStream ip5 = new FileInputStream("src//test//java//com//nimi//ui_automation//main//testdata//employeeRegister.properties");
            prop5.load(ip5);

            prop6 = new Properties();
            FileInputStream ip6 = new FileInputStream("src//test//java//com//nimi//ui_automation//main//testdata//inviteAdmins.properties");
            prop6.load(ip6);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
