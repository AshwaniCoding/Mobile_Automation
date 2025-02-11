package com.automation;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class RoyalBrothersSwipe {
    static AppiumDriver driver;

    public static void main(String[] args) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "393d1f1a3b25");
        capabilities.setCapability("app", "C:\\Users\\291504\\Downloads\\Mobile APK's\\RoyalBrothers.apk");


        driver = new AppiumDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement mayBeLaterBtn = driver.findElement(By.xpath("//android.widget.Button[@text='MAYBE LATER']"));
        mayBeLaterBtn.click();

        WebElement mayBeLaterBtn2 = driver.findElement(By.xpath("//android.widget.Button[@text='MAYBE LATER']"));
        mayBeLaterBtn2.click();

        WebElement skipBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='SKIP']"));
        skipBtn.click();

        WebElement selectCityInput = driver.findElement(By.xpath("//android.widget.EditText[contains(@text,'Select city')]"));
        selectCityInput.sendKeys("Trivandrum");

        WebElement firstCity = driver.findElement(By.xpath("//android.widget.ScrollView//android.widget.TextView"));
        firstCity.click();



    }
}
