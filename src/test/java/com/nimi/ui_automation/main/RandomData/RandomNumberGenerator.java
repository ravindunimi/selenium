package com.nimi.ui_automation.main.RandomData;

import com.nimi.ui_automation.main.base.TestBase;

import java.util.Random;

public class RandomNumberGenerator extends TestBase {
    static Random random = new Random();

    public static int randomNumber = random.nextInt(900) + 100;
}
