package com.automation;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class Test2 {
    static AppiumDriver driver;

    public static void main(String[] args) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "393d1f1a3b25");
        capabilities.setCapability("app", "C:\\Users\\291504\\Downloads\\Mobile APK's\\Expedia.apk");
        capabilities.setCapability("appPackage", "com.expedia.bookings");
        capabilities.setCapability("appActivity", "com.expedia.bookings.activity.RouterActivity");


        driver = new AppiumDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        WebElement getStartedBtn = driver.findElement(By.xpath("//android.widget.TextView[@text='Get started']"));

    }
}
