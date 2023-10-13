package com.nimi.ui_automation.main.RandomData;

import com.nimi.ui_automation.main.base.TestBase;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringGenerator extends TestBase {
    public static String randomString = RandomStringUtils.randomAlphanumeric(10);
}
