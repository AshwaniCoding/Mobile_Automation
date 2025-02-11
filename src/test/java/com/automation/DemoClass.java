package com.automation;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DemoClass {
    public static void main(String[] args) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","393d1f1a3b25");
        capabilities.setCapability("app","C:\\Users\\291504\\Downloads\\MobileAutomationAPKs-master\\EaseMyTrip.apk");
        capabilities.setCapability("appPackage","com.easemytrip.android");
        capabilities.setCapability("appActivity","com.easemytrip.android.SplashScreenActivity");

        AppiumDriver driver = new AppiumDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        WebElement dontAllowBtn = driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button"));
        System.out.println(dontAllowBtn.isDisplayed());
        dontAllowBtn.click();
        WebElement maybeLaterBtn = driver.findElement(By.id("com.easemytrip.android:id/btn_update_later"));
        System.out.println(maybeLaterBtn.isDisplayed());
        maybeLaterBtn.click();
        WebElement flightsTab = driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.easemytrip.android:id/imgWallet'])[1]"));
        System.out.println(flightsTab.isDisplayed());
        flightsTab.click();




    }
}
